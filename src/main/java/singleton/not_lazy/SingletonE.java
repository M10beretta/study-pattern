package singleton.not_lazy;

/**
 * Enum Singleton<p>
 * + Потокобезопасность<br>
 * + Сериализация из коробки<br>
 * + Возможность использования EnumSet, EnumMap и т.д.<br>
 * + Поддержка switch<br>
 * - Не ленивая инициализация
 */
public enum SingletonE {
    INSTANCE;
}
