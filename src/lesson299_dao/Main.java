package lesson299_dao;

// DAO

public class Main {
    public static void main(String[] args) {
        printData(new Db());
        printData(new Fs());
    }

    private static void printData(Data data) {
        System.out.println(data.getData());
    }
}


interface Data {
    String getData();
}

class Db implements Data{
    String getFromTable() {
        return "data from db";
    }

    @Override
    public String getData() {
        return getFromTable();
    }
}

class Fs implements Data{
    String getFromFileSystem() {
        return "data from fs";
    }

    @Override
    public String getData() {
        return getFromFileSystem();
    }
}

