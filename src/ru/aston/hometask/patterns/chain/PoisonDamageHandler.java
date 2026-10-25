package ru.aston.hometask.patterns.chain;

//Обработчик урона от яда

public class PoisonDamageHandler extends DamageHandler {
    private static final double REDUCTION_FACTOR = 0.7;

    @Override
    protected boolean handleDamage(Damage damage) {
        if (damage.getType() == DamageType.POISON) {
            int reduced = (int) (damage.getAmount() * (1 - REDUCTION_FACTOR));
            System.out.println("Иммунитет к яду поглощает " + REDUCTION_FACTOR * 100 + "% урона. "
                    + damage.getAmount() + " -> " + reduced);
            return true;
        }
        return false;
    }
}