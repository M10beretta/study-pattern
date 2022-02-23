package singleton.slow;

/**
 * Synchronized Accessor<p>
 * + Потокобезопасность<br>
 * + Ленивая инициализация<br>
 * - Низкая производительность (критическая секция) в наиболее типичном доступе
 */
public class SingletonC {
    private static SingletonC instance;

    public static synchronized SingletonC getInstance() {
        if (instance == null) {
            instance = new SingletonC();
        }
        return instance;
    }
}
