package lesson302_service_locator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(new String[]{
                        "Service1",
                        "Service1",
                        "Service2",
                        "Service2",
                        "Service1",
                        "Service1",
                        "Service2",
                        "Service2"})
                .forEach(x -> ServiceLocator.getService(x).execute());
    }
}

interface Service {

    String getName();

    void execute();
}

abstract class ServiceImpl implements Service {
    private final String classSimpleName = getClass().getSimpleName();

    @Override
    public String getName() {
        return classSimpleName;
    }

    @Override
    public void execute() {
        System.out.println("Executing " + getAddress());
    }

    private String getAddress() {
        String[] split = this.toString().split("\\.");
        return split[split.length - 1];
    }
}

class Service1 extends ServiceImpl {
}

class Service2 extends ServiceImpl {
}

class InitialContext {
    public Object lookup(String jndiName) {
        Object res = null;
        if (jndiName.equalsIgnoreCase("SERVICE1")) {
            res = new Service1();
        }
        if (jndiName.equalsIgnoreCase("SERVICE2")) {
            res = new Service2();
        }
        return res;
    }
}

class Cache {
    private final List<Service> services = new ArrayList<>();

    public Service getService(String name) {
        return services
                .stream()
                .filter(service -> service.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void addService(Service service) {
        if (!services.contains(service)) {
            services.add(service);
        }
    }
}

class ServiceLocator {
    private final static Cache cache = new Cache();

    public static Service getService(String jndiName) {
        Service res = cache.getService(jndiName);
        if (res == null) {
            res = (Service) new InitialContext().lookup(jndiName);
            cache.addService(res);
        }
        return res;
    }
}