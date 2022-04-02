package command.husivm;

/**
 * несколько комманд обернуть в {@link Receiver}. <br>
 * В нем же можно сделать отмену при неудачной попытке.
 * Как в транзакции
 */
public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        receiver.addCommand(new MouseClick());
        receiver.addCommand(new MousePress());
        receiver.runCommands();
    }
}


