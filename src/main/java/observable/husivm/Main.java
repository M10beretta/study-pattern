package observable.husivm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var observerA = new Observer("observerA");
        var observerB = new Observer("observerB");
        var observerC = new Observer("observerC");

        observerA.setState("one");
        observerB.setState("two");
        observerC.setState("three");
    }
}

interface MyObservable {
    void update();
}


class Observer implements MyObservable {
    private static final List<Observer> observers = new ArrayList<>();
    private final String name;
    private String state;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public void update() {
        System.out.println(name + " change status: " + state);
    }
}