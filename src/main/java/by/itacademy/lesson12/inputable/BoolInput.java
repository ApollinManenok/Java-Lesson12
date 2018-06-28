package by.itacademy.lesson12.inputable;

import java.util.Scanner;

public class BoolInput implements Inputable<Boolean> {
    @Override
    public Boolean input() {
        return new Scanner(System.in).nextBoolean();
    }
}
