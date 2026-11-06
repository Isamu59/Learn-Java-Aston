package ru.aston.homework4;

import java.util.concurrent.CyclicBarrier;

public class Livelock {

    public static void run() {
        CyclicBarrier barrier = new CyclicBarrier(2);
        boolean[] polite = {true, true};

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    barrier.await();

                    if (polite[0]) {
                        System.out.println("Поток 1 уступает дорогу");
                        polite[0] = false;
                    } else {
                        System.out.println("Поток 1 снова уступает");
                        polite[0] = true;
                    }

                    barrier.await();
                } catch (Exception e) {
                    return;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    barrier.await();

                    if (polite[1]) {
                        System.out.println("Поток 2 уступает дорогу");
                        polite[1] = false;
                    } else {
                        System.out.println("Поток 2 снова уступает");
                        polite[1] = true;
                    }

                    barrier.await();
                } catch (Exception e) {
                    return;
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}