package lesson270_abstract_factory;

// Abstract Factory - фабрика фабрик

public class Main {
    public static void main(String[] args) {
        Factory carFactory = new AbstractFactory().createFactory("CarFactory");
        Factory tankFactory = new AbstractFactory().createFactory("MotoFactory");

        Car toyota = carFactory.createCar("Toyota");
        Car audi = carFactory.createCar("Audi");
        Moto yamaha = tankFactory.createTank("Yamaha");
        Moto suzuki = tankFactory.createTank("Suzuki");

        toyota.drive();
        audi.drive();
        yamaha.drive();
        suzuki.drive();
    }
}


class AbstractFactory {
    Factory createFactory(String typeOfFactory) {
        return switch (typeOfFactory) {
            case "CarFactory" -> new CarFactory();
            case "MotoFactory" -> new TankFactory();
            default -> null;
        };
    }
}

interface Factory {
    Car createCar(String typeOfCar);
    Moto createTank(String typeOfTank);
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


class CarFactory implements Factory {
    public Car createCar(String typeOfCar) {
        return switch (typeOfCar) {
            case "Toyota" -> new Toyota();
            case "Audi" -> new Audi();
            default -> null;
        };
    }

    @Override
    public Moto createTank(String typeOfTank) {
        return null;
    }
}


interface Moto {
    void drive();
}

class Yamaha implements Moto {
    @Override
    public void drive() {
        System.out.println("drive Yamaha");
    }
}

class Suzuki implements Moto {
    @Override
    public void drive() {
        System.out.println("drive Suzuki");
    }
}

class TankFactory implements Factory {
    public Moto createTank(String typeOfTank) {
        return switch (typeOfTank) {
            case "Yamaha" -> new Yamaha();
            case "Suzuki" -> new Suzuki();
            default -> null;
        };
    }

    @Override
    public Car createCar(String typeOfCar) {
        return null;
    }
}
