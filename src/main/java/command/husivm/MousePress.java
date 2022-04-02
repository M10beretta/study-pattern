package command.husivm;

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
