public class App {
    public static void main(String[] args) {
        Immutable immut = new Immutable(1);

        Immutable.Mutable obj = immut.getMutable();
        obj.setValue(100);

        System.out.println(immut.getMutable().getValue());
    }
}

final class Immutable {

    private final Mutable mutable;

    public Immutable(int value) {
        this.mutable = new Mutable(value);
    }

    public Mutable getMutable() {
        return new Mutable(mutable.getValue());
    }

    public static class Mutable {
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
    }
}