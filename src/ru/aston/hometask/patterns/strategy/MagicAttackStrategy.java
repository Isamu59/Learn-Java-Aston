package ru.aston.hometask.patterns.strategy;

//Стратегия магической атаки

public class MagicAttackStrategy implements AttackStrategy {
    @Override
    public void attack(String target) {
        System.out.println("Боец бросает огненный шар в " + target + " (магия)");
    }

    @Override
    public String getName() {
        return "Магия";
    }
}