package ru.aston.homework4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Домашнее задание №4");
        System.out.println("1 — Deadlock");
        System.out.println("2 — Livelock");
        System.out.println("3 — Чередование чисел 1 и 2");
        System.out.print("Выберите задание: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> Deadlock.run();
            case 2 -> Livelock.run();
            case 3 -> AlternatingNumbers.run();
            default -> System.out.println("Неверный номер задания");
        }
    }
}