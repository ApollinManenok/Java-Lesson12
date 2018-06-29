package by.itacademy.lesson12.inputable;

import java.util.Scanner;

public interface Inputable<T> {
    Scanner scan = new Scanner(System.in);

    T getValue(String message);
}
