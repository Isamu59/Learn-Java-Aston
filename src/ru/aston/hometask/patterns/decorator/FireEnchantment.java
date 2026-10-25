package ru.aston.hometask.patterns.decorator;

//Зачарвание огнём

public class FireEnchantment extends WeaponDecorator {
    private static final int FIRE_DAMAGE = 5;

    public FireEnchantment(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public int getDamage() {
        return super.getDamage() + FIRE_DAMAGE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [Огненное зачарование]";
    }
}