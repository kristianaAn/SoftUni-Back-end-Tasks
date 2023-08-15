package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapterXml extends XmlAdapter<String, LocalDate> {
    private final static String CUSTOM_DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public LocalDate unmarshal(String s) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CUSTOM_DATE_FORMAT);
        return LocalDate.parse(s, formatter);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return null;
    }
}
