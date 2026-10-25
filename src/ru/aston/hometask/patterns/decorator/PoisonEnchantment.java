package ru.aston.hometask.patterns.decorator;

//Ядовитое покрытие

public class PoisonEnchantment extends WeaponDecorator {
    private static final int POISON_DAMAGE = 3;

    public PoisonEnchantment(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public int getDamage() {
        return super.getDamage() + POISON_DAMAGE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [Ядовитое покрытие]";
    }
}