package lesson281_facade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// цель - спрятать функционал за примитивным интерфейсом (под интерфесом подразумевается метод через который мы работаем)
// переносим логику в какой-либо класс или метод

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/com/mber/husivm/lesson281_facade/file.txt";
        System.out.println(new FileReadFacade().readFile(path));

    }
}

class FileReadFacade {
    String readFile(String path) throws IOException {
        var fr = new BufferedReader(new FileReader(path));
        var sb = new StringBuilder();
        int j;
        while ((j = fr.read()) != -1) {
            sb.append((char) j);
        }
        return sb.toString();
    }
}