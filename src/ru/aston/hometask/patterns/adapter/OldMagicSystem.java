package ru.aston.hometask.patterns.adapter;

//Cтарая магическая система из предыдущей версии игры — неудобный интерфейс, менять нельзя

public class OldMagicSystem {
    /*
     * Старый метод каста заклинания с неудобной сигнатурой.
     * @param spellName название заклинания
     * @param targetLevel уровень цели
     * @param manaCost стоимость маны
     * @return строка с результатом каста
     */
    public String castSpell(String spellName, int targetLevel, int manaCost) {
        return "Старый каст: " + spellName + " на цель уровня " + targetLevel + " за " + manaCost + " маны";
    }
}