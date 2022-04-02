package command.main;

public class CommandImplA extends AbstractCommand{

    public CommandImplA(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.doMethodA();
    }

    @Override
    public void rollBack() {
        receiver.rollBackMethodA();
    }
}
