package husivm;

/**
 * По цепочке запускаем код, передавая ссылку на следующий объект.
 */
public class Main {
    public static void main(String[] args) {

        var consoleMP = new ConsoleMessagePrinter();
        var fileMP = new FileMessagePrinter();
        var dbMP = new DbMessagePrinter();

        consoleMP.setNextMessagePrinter(fileMP);
        fileMP.setNextMessagePrinter(dbMP);

        consoleMP.print("hi");
    }
}


abstract class MessagePrinter{
    private MessagePrinter nextMessagePrinter;

    public void setNextMessagePrinter(MessagePrinter nextMessagePrinter) {
        this.nextMessagePrinter = nextMessagePrinter;
    }

    void print(String message){
        printMessage(message);
        if (nextMessagePrinter!=null){
            nextMessagePrinter.print(message);
        }
    }

    abstract void printMessage(String message);
}



class ConsoleMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to console: " + message);
    }
}

class FileMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to file: " + message);
    }
}

class DbMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to db: " + message);
    }
}