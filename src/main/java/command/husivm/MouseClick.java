package command.husivm;

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
