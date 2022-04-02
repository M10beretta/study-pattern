package command.main;

public interface Command {
    void execute();

    void rollBack();
}
