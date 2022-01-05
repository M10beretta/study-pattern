package husivm;

public class Main {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new Audi());
        carWash.washCar(new TruckWrapper(new Scania()));
    }
}

class CarWash{
    public  void washCar(Car car){
        car.washCar();
    }
}


class TruckWrapper implements Car {
    private  final Truck truck;

    public TruckWrapper(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void washCar() {
        truck.washTruck();
    }
}


interface Car{
    void washCar();
}


class Audi implements Car{
    @Override
    public void washCar() {

    }
}


interface Truck {
    void washTruck();
}

class Scania implements Truck {
    @Override
    public void washTruck() {
    }
}