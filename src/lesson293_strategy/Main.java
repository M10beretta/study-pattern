package lesson293_strategy;

// Strategy
// один раз прописываем в контексте стратегию
public class Main {
    public static void main(String[] args) {
        double startPrice = 100;
        Context contextHalf = new Context(new HalfPrice());
        Context contextFull = new Context(new FullPrice());
        System.out.println(contextHalf.getPrice(startPrice));
        System.out.println(contextFull.getPrice(startPrice));
    }
}

interface Strategy {
    double getPrice(double price);
}

class FullPrice implements Strategy {
    @Override
    public double getPrice(double price) {
        return price;
    }
}

class HalfPrice implements Strategy {
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}

class Context{
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price) {
        return strategy.getPrice(price);
    }
}