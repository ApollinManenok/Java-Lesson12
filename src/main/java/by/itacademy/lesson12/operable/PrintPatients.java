package by.itacademy.lesson12.operable;

import by.itacademy.lesson12.domain.Patient;
import by.itacademy.lesson12.domain.Registry;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintPatients extends BaseRegistryOperation {
    private static final Logger LOGGER = Logger.getLogger(PrintPatients.class.getName());

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
            LOGGER.log(Level.INFO, "Something interrupted", e);
        }
    }

    @Override
    public String typo() {
        return "Print all patients";
    }
}
