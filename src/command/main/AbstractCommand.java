package command.main;

public abstract class AbstractCommand implements Command {
    protected final Receiver receiver;

    protected AbstractCommand(Receiver receiver) {
        this.receiver = receiver;
    }
}
