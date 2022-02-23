package command.main;

public record Receiver(String name) {

    public void doMethodA() {
        System.out.println(name + " does method A");
    }

    public void doMethodB() {
        System.out.println(name + " does method B");
    }

    public void rollBackMethodA() {
        System.out.println(name + " roll backs method A");
    }

    public void rollBackMethodB() {
        System.out.println(name + " roll backs method B");
    }
}
