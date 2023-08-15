package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class LibraryMembersImportDTO {
//    first name - accepts char sequence (between 2 to 30 inclusive).
//    last name - accepts char sequence (between 2 to 30 inclusive).
//    address - accepts char sequence (between 2 to 40 inclusive). Can be nullable.
//    phone number - accepts char sequence (between 2 to 20 inclusive)

    @Length(min = 2, max = 40)
    private String address;

    @Length(min = 2, max = 30)
    @NotNull
    private String firstName;

    @Length(min = 2, max = 30)
    @NotNull
    private String lastName;

    @Length(min = 2, max = 20)
    @NotNull
    private String phoneNumber;

    public LibraryMembersImportDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
