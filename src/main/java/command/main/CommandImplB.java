package command.main;

public class CommandImplB extends AbstractCommand{

    public CommandImplB(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.doMethodB();
    }

    @Override
    public void rollBack() {
        receiver.rollBackMethodB();
    }
}
