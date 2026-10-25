package ru.aston.hometask.patterns.decorator;

//Декоратор-класс для зачарований

public abstract class WeaponDecorator implements Weapon {
    protected final Weapon decoratedWeapon;

    public WeaponDecorator(Weapon decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    @Override
    public int getDamage() {
        return decoratedWeapon.getDamage();
    }

    @Override
    public String getDescription() {
        return decoratedWeapon.getDescription();
    }
}