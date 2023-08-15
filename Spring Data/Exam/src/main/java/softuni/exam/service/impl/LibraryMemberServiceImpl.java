package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMembersImportDTO;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.models.Constants.*;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    private final LibraryMemberRepository libraryMemberRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtils validationUtils;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(LIBRARY_MEMBER_IMPORT_FILE_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder sb = new StringBuilder();

        LibraryMembersImportDTO[] libraryMembersImportDTOS = this.gson
                .fromJson(readLibraryMembersFileContent(), LibraryMembersImportDTO[].class);

        for (LibraryMembersImportDTO libraryMemberImportDTO : libraryMembersImportDTOS) {
            sb.append(System.lineSeparator());

            if (!validationUtils.isValid(libraryMemberImportDTO)) {
                sb.append(String.format(INVALID_OPERATION, LIBRARY_MEMBER));
                continue;
            }

            if (this.libraryMemberRepository.findByPhoneNumber(libraryMemberImportDTO.getPhoneNumber()).isPresent()) {
                sb.append(String.format(INVALID_OPERATION, LIBRARY_MEMBER));
                continue;
            }

            LibraryMember libraryMemberToSave = this.modelMapper.map(libraryMemberImportDTO, LibraryMember.class);
            this.libraryMemberRepository.save(libraryMemberToSave);
            sb.append(String.format(SUCCESSFUL_IMPORT,
                    LIBRARY_MEMBER,
                    libraryMemberImportDTO.getFirstName() + " - " + libraryMemberImportDTO.getLastName()));
        }

        return sb.toString().trim();
    }
}
