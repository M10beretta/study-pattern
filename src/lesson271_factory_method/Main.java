package lesson271_factory_method;

// Factory Method
// создание объекта через метод

public class Main {
    public static void main(String[] args) {
        Person person = Person.create();
    }
}

class Person {
    private Person() {
    }

    public static Person create() {
        return new Person();
    }
}


