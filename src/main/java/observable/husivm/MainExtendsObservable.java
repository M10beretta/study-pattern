package observable.husivm;

import java.util.Observable;
import java.util.Scanner;

public class MainExtendsObservable {
    public static void main(String[] args) {
        System.out.println("Enter text: ");
        var eventSource = new EventSource();

        eventSource.addObserver((obj, arg) -> System.out.println("Recueved responce: " + arg));
        new Thread(eventSource).start();
    }
}

// Observable is @Deprecated
class EventSource extends Observable implements Runnable {
    @Override
    public void run() {
        while (true) {
            String response = new Scanner(System.in).next();

            if(response.equalsIgnoreCase("stop")) {
                System.out.println("EventSource stopped");
                break;
            }

            setChanged();
            notifyObservers(response);
        }
    }
}
