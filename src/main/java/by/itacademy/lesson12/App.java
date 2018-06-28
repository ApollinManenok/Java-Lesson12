package by.itacademy.lesson12;

public class App {
    public static void main(String[] args) {
        System.setProperty("java.util.logging.config.file", "logging.properties");
        Menu menu = new Menu();
        menu.list();
    }
}
