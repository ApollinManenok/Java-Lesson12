package by.itacademy.lesson12.operable;

import by.itacademy.lesson12.ExceptionHandler;
import by.itacademy.lesson12.domain.PatientDateFormat;
import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;
import by.itacademy.lesson12.inputable.BoolInput;
import by.itacademy.lesson12.inputable.DateInput;
import by.itacademy.lesson12.inputable.StringInput;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.logging.Level;

public class ConsoleAddPatient extends BaseRegistryOperation {
    public ConsoleAddPatient(Registry registry) {
        super(registry);
    }

    @Override
    public void operation() {
        try {
            String name = new StringInput().getValue("Enter patient name");
            String surname = new StringInput().getValue("Enter patient surname");
            LocalDate birth = new DateInput(PatientDateFormat.INSTANCE.format()).getValue("Enter patient date of birth");
            Boolean status = new BoolInput().getValue("Enter patient status");
            getRegistry().addPatient(new Patient(name, surname, birth, status));
        } catch (DateTimeParseException | InputMismatchException e) {
            new ExceptionHandler().handle(Level.SEVERE, "Can't add patient with wrong data", e);
        }
    }

    @Override
    public String typo() {
        return "Adding patient from console";
    }
}
