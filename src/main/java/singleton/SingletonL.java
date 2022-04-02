package singleton;

/**
 * Double Checked Locking & volatile<p>
 * + Потокобезопасность<br>
 * + Ленивая инициализация<br>
 * + Высокая производительность<br>
 * - Поддерживается только с JDK 1.5 [5]
 */
public class SingletonL {
    private static volatile SingletonL instance;

    private SingletonL() {
    }

    public static SingletonL getInstance() {
        SingletonL localInstance = instance;
        if (localInstance == null) {
            synchronized (SingletonL.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SingletonL();
                }
            }
        }
        return localInstance;
    }
}