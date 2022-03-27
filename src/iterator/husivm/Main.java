package iterator.husivm;

public class Main {
    public static void main(String[] args) {
        var arrayContainer = new ArrayContainer();
        var iterator = arrayContainer.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}


