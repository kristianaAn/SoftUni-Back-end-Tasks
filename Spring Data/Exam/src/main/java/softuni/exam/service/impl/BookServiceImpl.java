package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BooksImportDTO;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.models.Constants.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final Gson gson;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;


    public BookServiceImpl(BookRepository bookRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOKS_IMPORT_FILE_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder sb = new StringBuilder();

        BooksImportDTO[] booksImportDTOS = this.gson.fromJson(readBooksFromFile(), BooksImportDTO[].class);

        for (BooksImportDTO bookImportDTO : booksImportDTOS) {
            sb.append(System.lineSeparator());

            if (!validationUtils.isValid(bookImportDTO)) {
                sb.append(String.format(INVALID_OPERATION, BOOK));
                continue;
            }

            if (this.bookRepository.findByTitle(bookImportDTO.getTitle()).isPresent()) {
                sb.append(String.format(INVALID_OPERATION, BOOK));
                continue;
            }

            Book bookToSave = this.modelMapper.map(bookImportDTO, Book.class);
            this.bookRepository.save(bookToSave);
            sb.append(String.format(SUCCESSFUL_IMPORT,
                    BOOK,
                    bookImportDTO.getAuthor() + " - " + bookImportDTO.getTitle()));
        }

        return sb.toString().trim();
    }
}
