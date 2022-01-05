package lesson274_prototype;

// прототип - класс который умеет себя клонировать
// всегда возвращается клон объекта
/* может понадобится при имплементации гибернейта, когда создаем большие объекты,
   чтобы не лазить в БД проще закэшировать и клонировать */
// можем делать изменения которые не отобразятся на оригинале

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        var cache = new Cache();
        var student = new Student();
        System.out.println(student);
        cache.setStudent(student);
        System.out.println(cache.getStudent());
    }
}

class Student implements Cloneable {
    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

class Cache {
    private Student student;

    public Student getStudent() throws CloneNotSupportedException {
        return student.clone();
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}