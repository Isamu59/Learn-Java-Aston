package ru.aston.hometask;

import java.util.Objects;

public final class Immutable {
    private final Mutable mutable;

    public Immutable(Mutable mutable) {
        this.mutable = new Mutable(mutable.getValue());
    }

    public Mutable getMutable() {
        return new Mutable(mutable.getValue());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Immutable immutable = (Immutable) otherObject;
        return Objects.equals(mutable, immutable.mutable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mutable);
    }
}
