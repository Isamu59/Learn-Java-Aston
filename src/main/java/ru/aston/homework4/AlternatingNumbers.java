package ru.aston.homework4;

import java.util.concurrent.Semaphore;

public class AlternatingNumbers {

    public static void run() {
        Semaphore first = new Semaphore(1);
        Semaphore second = new Semaphore(0);

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    first.acquire();
                    System.out.print("1 ");
                    second.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    second.acquire();
                    System.out.print("2 ");
                    first.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}