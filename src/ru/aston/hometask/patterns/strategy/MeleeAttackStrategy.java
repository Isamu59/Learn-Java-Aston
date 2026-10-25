package ru.aston.hometask.patterns.strategy;

//Стратегия ближнего боя

public class MeleeAttackStrategy implements AttackStrategy {
    @Override
    public void attack(String target) {
        System.out.println("Боец наносит удар мечом по " + target + " (ближний бой)");
    }

    @Override
    public String getName() {
        return "Ближний бой";
    }
}