package visitor.husivm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var dog = new Dog();
        var cat = new Cat();

        voice(dog, cat);

    }

    private static void voice(Animal animal, Animal... animals) {
        var v = new VoiceVisitor();
        animal.voice(v);
        Arrays.stream(animals).forEach(x -> x.voice(v));
    }
}


