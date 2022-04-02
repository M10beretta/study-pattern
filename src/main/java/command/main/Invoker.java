package command.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Invoker {
    private final List<Command> commands = new ArrayList<>();

    public void executeCommands(Command command){
        commands.add(command);
        command.execute();
    }

    public void rollbackAll(){
        Collections.reverse(commands);
        commands.forEach(Command::rollBack);
    }
}
