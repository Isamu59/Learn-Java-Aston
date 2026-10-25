package ru.aston.hometask.patterns.chain;

//Класс сопротивлений

public abstract class DamageHandler {
    private DamageHandler next;

    public DamageHandler setNext(DamageHandler next) {
        this.next = next;
        return next;
    }

    public void handle(Damage damage) {
        boolean handled = handleDamage(damage);
        if (!handled && next != null) {
            next.handle(damage);
        } else if (!handled && next == null) {
            System.out.println("Урон " + damage + " прошёл по здоровью полностью (нет сопротивления)!");
        }
    }

    protected abstract boolean handleDamage(Damage damage);

    protected DamageHandler getNext() {
        return next;
    }
}