package by.itacademy.lesson12.inputable;

public class BoolInput implements Inputable<Boolean> {
    @Override
    public Boolean getValue(String message) {
        System.out.print(message + "\n>>> ");
        boolean result = scan.nextBoolean();
        scan.nextLine();
        return result;
    }
}
