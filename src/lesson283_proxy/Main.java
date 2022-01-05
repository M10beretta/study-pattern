package lesson283_proxy;

// Proxy
// вклинивается между классами и добавляет свой функционал

public class Main {
    public static void main(String[] args) {
        CarI audi = new AudiProxy();
        audi.drive();
    }
}

interface CarI {
    void drive();
}

class AudiProxy implements CarI {
    CarI car = new Audi();

    @Override
    public void drive() {
        System.out.println("proxy code");
        car.drive();
    }
}

class Audi implements CarI {
    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}