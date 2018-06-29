package by.itacademy.lesson12.inputable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateInput implements Inputable<LocalDate> {
    private DateTimeFormatter format;

    public DateInput(DateTimeFormatter format) {
        this.format = format;
    }

    @Override
    public LocalDate getValue(String message) {
        System.out.print(message + "\n>>> ");
        return LocalDate.parse(scan.nextLine(), format);
    }
}
