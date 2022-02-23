package command.husivm;

import java.util.ArrayList;
import java.util.List;

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

/**
 * еще называют Invoker
 */
class Receiver {
    private final List<Command> commands = new ArrayList<>();

    void addCommand(Command command) {
        commands.add(command);
    }

    void runCommands() {
        try {
            commands.forEach(Command::execute);
        } catch (Exception e) {
            commands.forEach(Command::revert);
        }
    }
}


interface Command {
    void execute();

    void revert();

}


class MouseClick implements Command {
    @Override
    public void execute() {
        System.out.println("click command");
    }

    @Override
    public void revert() {
        System.out.println("revert click command");
    }
}

class MousePress implements Command {
    @Override
    public void execute() {
        System.out.println("press command");
    }

    @Override
    public void revert() {
        System.out.println("revert press command");
    }
}


