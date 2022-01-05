package lesson301_intercepting_filter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static FilterManager fm = new FilterManager();

    public static void main(String[] args) {
        fm.setFilter(new AuthFilter());
        fm.setFilter(new IpFilter());
        fm.filterRequest("home");
        fm.filterRequest("user");
    }
}

interface Filter {
    void execute(String data);
}


class AuthFilter implements Filter {
    @Override
    public void execute(String data) {
        System.out.println("auth filter data: " + data);
    }
}

class IpFilter implements Filter {
    @Override
    public void execute(String data) {
        System.out.println("ip filter data: " + data);
    }
}


class FilterChain {
    List<Filter> filters = new ArrayList<>();
    Target target = new Target();

    void addFilter(Filter filter) {
        filters.add(filter);
    }

    void filter(String data) {
        for (Filter f : filters) {
            f.execute(data);
        }
        target.doJob(data);
    }
}

class FilterManager {
    FilterChain fc = new FilterChain();

    public void setFilter(Filter filter) {
        this.fc.addFilter(filter);
    }

    void filterRequest(String request) {
        fc.filter(request);
    }
}

class Target {
    public void doJob(String data) {
        System.out.println("data came in: " + data);
    }
}