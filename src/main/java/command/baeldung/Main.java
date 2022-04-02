package command.baeldung;

public class Main {
    public static void main(String[] args) {
        var executor = new TextFileOperationExecutor();
        var textFile = new TextFile("file.txt");

        System.out.println(executor.executeOperation(new OpenTextFileOperation(textFile)));
        System.out.println(executor.executeOperation(new SaveTextFileOperation(textFile)));


        System.out.println(executor.executeOperation(() -> "Opening file file.txt"));
        System.out.println(executor.executeOperation(() -> "Saving file file.txt"));


        executor.executeOperation(textFile::open);
        executor.executeOperation(textFile::save);
    }
}

