package singleton;

/**
 * On Demand Holder idiom<p>
 * + Ленивая инициализация<br>
 * + Высокая производительность<br>
 * - Невозможно использовать для не статических полей класса<br>
 */
public class SingletonH {

    private SingletonH() {
    }

    public static class SingletonHolder{
        public static final SingletonH HOLDER_INSTANCE = new SingletonH();

    }
    public static SingletonH getInstance(){
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
