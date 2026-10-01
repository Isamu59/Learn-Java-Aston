package ru.aston.hometask;

import java.util.Objects;

public class Mutable {
    private int value;

    public Mutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Mutable mutable = (Mutable) otherObject;
        return value == mutable.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
