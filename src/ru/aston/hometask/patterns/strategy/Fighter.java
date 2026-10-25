package ru.aston.hometask.patterns.strategy;

//Контекст — боец, который может менять стиль атаки во время боя

public class Fighter {
    private String name;
    private AttackStrategy attackStrategy;

    public Fighter(String name) {
        this.name = name;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void attack(String target) {
        if (attackStrategy == null) {
            System.out.println(name + " не знает, как атаковать!");
            return;
        }
        System.out.print(name + " атакует [" + attackStrategy.getName() + "]: ");
        attackStrategy.attack(target);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Fighter{name='" + name + "', strategy=" + (attackStrategy != null ? attackStrategy.getName() : "none") + "}";
    }
}