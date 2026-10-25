package ru.aston.hometask.patterns.chain;

//Обработчик физического урона

public class PhysicalDamageHandler extends DamageHandler {
    private static final double REDUCTION_FACTOR = 0.3;

    @Override
    protected boolean handleDamage(Damage damage) {
        if (damage.getType() == DamageType.PHYSICAL) {
            int reduced = (int) (damage.getAmount() * (1 - REDUCTION_FACTOR));
            System.out.println("Броня поглощает " + REDUCTION_FACTOR * 100 + "% физического урона. "
                    + damage.getAmount() + " -> " + reduced);
            return true;
        }
        return false;
    }
}