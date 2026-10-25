package ru.aston.hometask.patterns.strategy;

//Интерфейс стратегии атаки

public interface AttackStrategy {
    void attack(String target);
    String getName();
}