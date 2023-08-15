package softuni.exam.models.dto.borrowingRecord;

import org.hibernate.validator.constraints.Length;
import softuni.exam.util.DateAdapterXml;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordImportDTO {
    //    id - accepts integer values, a primary identification field, an auto incremented field.
//    borrow date - a date in the "yyyy-MM-dd" format.
//    return date - a date in the "yyyy-MM-dd" format.
//    remarks - can be used to store any relevant information. Accepts char sequence (between 3 to 100 inclusive). Can be nullable.

    @XmlElement(name = "borrow_date")
    @NotNull
    @XmlJavaTypeAdapter(DateAdapterXml.class)
    private LocalDate borrowDate;

    @XmlElement(name = "return_date")
    @NotNull
    @XmlJavaTypeAdapter(DateAdapterXml.class)
    private LocalDate returnDate;

    @XmlElement
    @NotNull
    private BookBase book;

    @XmlElement
    @NotNull
    private LibraryMemberBase member;

    @XmlElement(name = "remarks")
    @Length(min = 3, max = 100)
    private String remarks;

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BookBase getBook() {
        return book;
    }

    public void setBook(BookBase book) {
        this.book = book;
    }

    public LibraryMemberBase getMember() {
        return member;
    }

    public void setMember(LibraryMemberBase member) {
        this.member = member;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
