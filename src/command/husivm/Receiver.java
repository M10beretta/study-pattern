package command.husivm;

import java.util.ArrayList;
import java.util.List;

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
