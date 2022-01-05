package lesson300_front_controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                new Thread(() -> new DispatcherServlet().process(nextLine)).start();
            }
        }
    }
}

class DispatcherServlet {
    void process(String url) {
        switch (url) {
            case "home" -> new HomeController().show();
            case "user" -> new UserController().show();
            default -> new DefaultController().show();
        }
    }
}

class HomeController {
    void show() {
        System.out.println("this is home page");
    }
}

class UserController {
    void show() {
        System.out.println("this is user page");
    }
}

class DefaultController {
    void show() {
        System.out.println("error");
    }
}