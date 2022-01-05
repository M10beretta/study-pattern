package lesson303_transfer_object;

public class Main {
    public static void main(String[] args) {
        BusinessObject bo = new BusinessObject();
        System.out.println(bo.getUser().getName());
    }
}

// transfer object
class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UserService{
    User getUser();
}

class ServiceEJB implements UserService {
    public User getUser() {
        User user = new User();
        user.setName("Mike");
        return user;
    }
}

class BusinessObject {
    UserService serviceEJB = new ServiceEJB();

    public User getUser() {
        return serviceEJB.getUser();
    }
}