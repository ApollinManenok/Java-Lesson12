package by.itacademy.lesson12.operable;

import by.itacademy.lesson12.ExceptionHandler;
import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class PrintPatients extends BaseRegistryOperation {
    public PrintPatients(Registry registry) {
        super(registry);
    }

    @Override
    public void operation() {
        for (Patient element : getRegistry()) {
            System.out.println(element);
        }
        waiting();
    }

    private void waiting() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            new ExceptionHandler().handle(Level.INFO, "Something interrupted", e);
        }
    }

    @Override
    public String typo() {
        return "Print all patients";
    }
}
