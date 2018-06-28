package by.itacademy.lesson12;

public class App {
    public static void main(String[] args) {
        System.setProperty("java.util.logging.config.file", "logging.properties");
        String statusStr = "healthy";
        System.out.println(statusStr);
        Boolean status = null;
        if(statusStr.equalsIgnoreCase("HEALTHY") || statusStr.equalsIgnoreCase("ILL"))
            status = statusStr.equalsIgnoreCase("HEALTHY");
        System.out.println(status);
        Menu menu = new Menu();
        menu.list();
    }
}
