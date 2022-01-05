package lesson273_builder;

// Избавляет от множества конструкторов, или вызовов множества сеттеров.
// Уменьшает колличество кода, увеличивает читабельность

public class Main {
    public static void main(String[] args) {
        System.out.println(new SportCar.Builder("Ferrari").build());
        System.out.println(new SportCar.Builder("Lamborghini").setColor("red").build());
        System.out.println(new SportCar.Builder("Ford").setColor("blue").setMaxSpeed(300).build());
    }
}

class SportCar {
    private String name;
    private String color;
    private int maxSpeed;

    private SportCar() {
    }

    private SportCar(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;

    }

    static class Builder {
        private final String name;
        private String color;
        private int maxSpeed;

        public Builder(String name) {
            this.name = name;
            this.color = "black";
            this.maxSpeed = 200;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public SportCar build() {
            return new SportCar(this);
        }
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}