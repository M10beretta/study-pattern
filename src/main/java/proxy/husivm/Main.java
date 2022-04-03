package proxy.husivm;

// Proxy
// вклинивается между классами и добавляет свой функционал

public class Main {
    public static void main(String[] args) {
        Car audi = new AudiProxy();
        audi.drive();
    }
}

interface Car {
    void drive();
}

class AudiProxy implements Car {
    Car car = new Audi();

    @Override
    public void drive() {
        System.out.println("proxy code");
        car.drive();
    }
}

class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}
