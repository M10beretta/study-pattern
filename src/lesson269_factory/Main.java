package lesson269_factory;

// Factory

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Car toyota = factory.create("Toyota");
        Car audi = factory.create("Audi");

        toyota.drive();
        audi.drive();
    }
}

interface Car {
    void drive();
}

class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}

class Factory {
    public Car create(String typeOfCar) {
        return switch (typeOfCar) {
            case "Toyota" -> new Toyota();
            case "Audi" -> new Audi();
            default -> null;
        };
    }
}
