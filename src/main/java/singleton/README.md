# Одиночка

Также известен как: **Singleton**

**Одиночка** — это порождающий паттерн проектирования, который гарантирует, что у класса есть только один экземпляр, и
предоставляет к нему глобальную точку доступа.

[theory [refactoring.guru]](https://refactoring.guru/ru/design-patterns/singleton)

---

**Одиночка** — это порождающий паттерн, который гарантирует существование только одного объекта определённого класса, а также позволяет достучаться до этого объекта из любого места программы.

Одиночка имеет такие же преимущества и недостатки, что и глобальные переменные. Его невероятно удобно использовать, но он нарушает модульность вашего кода.

Вы не сможете просто взять и использовать класс, зависящий от одиночки в другой программе. Для этого придётся эмулировать присутствие одиночки и там. Чаще всего эта проблема проявляется при написании юнит-тестов.

[java example [refactoring.guru]](https://refactoring.guru/ru/design-patterns/singleton/java/example)

---

[Правильный Singleton в Java [habr.com]](https://habr.com/ru/post/129494/)