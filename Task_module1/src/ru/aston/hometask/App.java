package ru.aston.hometask;

public class App {
    public static void main(String[] args) {
        Mutable start = new Mutable(1);
        Immutable immut = new Immutable(start);

        Mutable obj = immut.getMutable();
        obj.setValue(100);

        System.out.println(immut.getMutable().getValue());
    }
}