package softuni.exam.models.dto.borrowingRecord;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "borrowing_records")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordsImportDTO {
    @XmlElement(name = "borrowing_record")
    List<BorrowingRecordImportDTO> borrowingRecordImportDTOS;

    public BorrowingRecordsImportDTO() {
    }

    public List<BorrowingRecordImportDTO> getBorrowingRecordImportDTOS() {
        return borrowingRecordImportDTOS;
    }

    public void setBorrowingRecordImportDTOS(List<BorrowingRecordImportDTO> borrowingRecordImportDTOS) {
        this.borrowingRecordImportDTOS = borrowingRecordImportDTOS;
    }
}
