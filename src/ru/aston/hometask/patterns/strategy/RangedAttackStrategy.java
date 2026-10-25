package ru.aston.hometask.patterns.strategy;

// Стратегия дальнего боя

public class RangedAttackStrategy implements AttackStrategy {
    @Override
    public void attack(String target) {
        System.out.println("Боец выпускает стрелу в " + target + " (дальний бой)");
    }

    @Override
    public String getName() {
        return "Дальний бой";
    }
}