package singleton.not_lazy;

/**
 * Static field<p>
 * + Потокобезопасность<br>
 * - Не ленивая инициализация
 */
public class SingletonA {
    public static final SingletonA INSTANCE = new SingletonA();

    private SingletonA() {
    }
}
