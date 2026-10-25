package ru.aston.hometask.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

//Реальная реализация сокровищницы

public class RealClanVault implements ClanVault {
    private final List<String> items = new ArrayList<String>();

    public RealClanVault() {
        System.out.println("[RealClanVault] Инициализация сокровищницы ...");
        // Имитация дорогой инициализации
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void deposit(String playerName, String item) {
        items.add(item);
        System.out.println("[RealClanVault] " + playerName + " положил в сокровищницу: " + item);
    }

    @Override
    public void withdraw(String playerName, String item) {
        if (items.remove(item)) {
            System.out.println("[RealClanVault] " + playerName + " взял из сокровищницы: " + item);
        } else {
            System.out.println("[RealClanVault] " + playerName + " не нашел в сокровищнице: " + item);
        }
    }

    @Override
    public void listContents(String playerName) {
        System.out.println("[RealClanVault] " + playerName + " просматривает содержимое: " + items);
    }
}