package ru.aston.hometask.patterns.decorator;

//Базовое оружие

public class IronSword implements Weapon {
    private static final int BASE_DAMAGE = 10;

    @Override
    public int getDamage() {
        return BASE_DAMAGE;
    }

    @Override
    public String getDescription() {
        return "Железный меч";
    }
}