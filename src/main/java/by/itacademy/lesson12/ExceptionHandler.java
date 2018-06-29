package by.itacademy.lesson12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(ExceptionHandler.class.getName());

    public void handle(Level level, String message, Throwable ex) {
        System.out.println(message);
        LOGGER.log(level, message, ex);
    }
}
