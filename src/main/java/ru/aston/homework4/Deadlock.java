package ru.aston.homework4;

import java.util.concurrent.CountDownLatch;

public class Deadlock {

    public static void run() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        CountDownLatch latch = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1 захватил lock1");

                latch.countDown();

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                synchronized (lock2) {
                    System.out.println("Поток 1 захватил lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Поток 2 захватил lock2");

                latch.countDown();

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                synchronized (lock1) {
                    System.out.println("Поток 2 захватил lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}