package ru.aston.hometask.patterns.proxy;

//Интерфейс клановой сокровищницы

public interface ClanVault {
    void deposit(String playerName, String item);
    void withdraw(String playerName, String item);
    void listContents(String playerName);
}