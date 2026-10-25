package ru.aston.hometask.patterns.adapter;

import ru.aston.hometask.patterns.strategy.AttackStrategy;

//Адаптер — подключает старую магическую систему к современному интерфейсу AttackStrategy

public class MagicSystemAdapter implements AttackStrategy {
    private final OldMagicSystem oldMagicSystem;
    private final String spellName;
    private final int manaCost;

    public MagicSystemAdapter(OldMagicSystem oldMagicSystem, String spellName, int manaCost) {
        this.oldMagicSystem = oldMagicSystem;
        this.spellName = spellName;
        this.manaCost = manaCost;
    }

    @Override
    public void attack(String target) {
        int targetLevel = 1;
        String result = oldMagicSystem.castSpell(spellName, targetLevel, manaCost);
        System.out.println("Адаптер: " + result + " -> цель: " + target);
    }

    @Override
    public String getName() {
        return "Старая магия: " + spellName;
    }
}