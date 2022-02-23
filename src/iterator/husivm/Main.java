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


interface Iterator {
    boolean hasNext();

    Object next();
}


interface Container {
    Iterator getIterator();
}


class ArrayContainer implements Container {
    String[] array = {"Mike", "Hank", "Elen"};

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return array[index++];
            }
            return null;
        }
    }
}