package ru.aston.hometask.patterns.chain;

//Класс урона

public class Damage {
    private final DamageType type;
    private final int amount;

    public Damage(DamageType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public DamageType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Damage{type=" + type.getDisplayName() + ", amount=" + amount + "}";
    }
}