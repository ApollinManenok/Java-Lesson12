package by.itacademy.lesson12.inputable;

public class StringInput implements Inputable<String> {
    @Override
    public String getValue(String message) {
        System.out.print(message + "\n>>> ");
        return scan.nextLine();
    }
}
