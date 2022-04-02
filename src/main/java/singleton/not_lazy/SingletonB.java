package singleton.not_lazy;

/**
 * Private static field<p>
 * + Потокобезопасность<br>
 * - Не ленивая инициализация
 */
public class SingletonB {
    private static final SingletonB instance = new SingletonB();

    private SingletonB() {
    }

    public static SingletonB getInstance() {
        return instance;
    }
}
