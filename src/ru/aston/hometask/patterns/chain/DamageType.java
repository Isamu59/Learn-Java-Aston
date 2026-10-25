package ru.aston.hometask.patterns.chain;

//Перечисление типов урона.

public enum DamageType {
    PHYSICAL("Физический"),
    FIRE("Огонь"),
    POISON("Яд"),
    LIGHT("Свет");

    private final String displayName;

    DamageType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}