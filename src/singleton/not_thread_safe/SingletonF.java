package singleton.not_thread_safe;

/**
 * Lazy initialization <p>
 * + Ленивая инициализация<br>
 * - Не потокобезопасно
 */
public class SingletonF {
    private static SingletonF instance;

    private SingletonF() {
    }

    public static SingletonF getInstance() {
        if (instance == null) {
            instance = new SingletonF();
        }
        return instance;
    }
}
