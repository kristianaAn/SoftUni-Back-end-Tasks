package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BooksExportDto;
import softuni.exam.models.dto.borrowingRecord.BorrowingRecordImportDTO;
import softuni.exam.models.dto.borrowingRecord.BorrowingRecordsImportDTO;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.Genre;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final LibraryMemberRepository libraryMemberRepository;
    private final XmlParser xmlParser;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;

    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository,
                                       BookRepository bookRepository, LibraryMemberRepository libraryMemberRepository,
                                       XmlParser xmlParser, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORD_IMPORT_FILE_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        BorrowingRecordsImportDTO borrowingRecordsImportDTO = this.xmlParser
                .fromFile(Path.of(BORROWING_RECORD_IMPORT_FILE_PATH).toFile(), BorrowingRecordsImportDTO.class);

        for (BorrowingRecordImportDTO borrowingRecordImportDTO : borrowingRecordsImportDTO.getBorrowingRecordImportDTOS()) {
            sb.append(System.lineSeparator());

            Optional<Book> bookByTitle = this.bookRepository.findByTitle(borrowingRecordImportDTO.getBook().getTitle());
            Optional<LibraryMember> libraryMember = this.libraryMemberRepository
                    .findById(borrowingRecordImportDTO.getMember().getId());

            if (bookByTitle.isEmpty()) {
                sb.append(String.format(INVALID_OPERATION, BORROWING_RECORD));
                continue;
            }

            if (libraryMember.isEmpty()) {
                sb.append(String.format(INVALID_OPERATION, BORROWING_RECORD));
                continue;
            }

            if (!this.validationUtils.isValid(borrowingRecordImportDTO)) {
                sb.append(String.format(INVALID_OPERATION, BORROWING_RECORD));
                continue;
            }

            BorrowingRecord borrowingRecordToSave = this.modelMapper.map(borrowingRecordImportDTO, BorrowingRecord.class);
            borrowingRecordToSave.setBook(bookByTitle.get());
            borrowingRecordToSave.setLibraryMember(libraryMember.get());
            this.borrowingRecordRepository.save(borrowingRecordToSave);
            sb.append(String.format(SUCCESSFUL_IMPORT,
                    BORROWING_RECORD,
                    borrowingRecordImportDTO.getBook().getTitle() + " - " + borrowingRecordImportDTO.getBorrowDate()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {
        return this.borrowingRecordRepository
                .findAllByBorrowDateBeforeAndBookGenreOrderByBorrowDateDesc(LocalDate.of(2021, 9, 10),
                        Genre.SCIENCE_FICTION)
                .stream()
                .map(borrowingRecord -> modelMapper.map(borrowingRecord, BooksExportDto.class))
                .map(BooksExportDto::toString)
                .collect(Collectors.joining())
                .trim();

    }
}
