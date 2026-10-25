package ru.aston.hometask.patterns.chain;

//Обработчик огненного урона

public class FireDamageHandler extends DamageHandler {
    private static final double REDUCTION_FACTOR = 0.5;

    @Override
    protected boolean handleDamage(Damage damage) {
        if (damage.getType() == DamageType.FIRE) {
            int reduced = (int) (damage.getAmount() * (1 - REDUCTION_FACTOR));
            System.out.println("Сопротивление огню поглощает " + REDUCTION_FACTOR * 100 + "% урона. "
                    + damage.getAmount() + " -> " + reduced);
            return true;
        }
        return false;
    }
}