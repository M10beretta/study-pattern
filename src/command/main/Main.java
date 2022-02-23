package command.main;

public class Main {
    public static void main(String[] args) {
        var invoker = new Invoker();
        var receiver = new Receiver("receiverA");
        invoker.executeCommands(new CommandImplA(receiver));
        invoker.executeCommands(new CommandImplA(receiver));
        invoker.executeCommands(new CommandImplB(receiver));
        invoker.rollbackAll();
    }
}
