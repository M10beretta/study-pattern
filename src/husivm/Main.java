package husivm;

import java.util.ArrayList;
import java.util.List;

/**
 * Что-бы не делать рассылку на всех.
 * <br> Mediator - объект, который облегчает общение обьектов.
 * <br> Самый элементарный пример это RadioButton - когда нажимаем одну кнопку, остальные должны стать в {@code false}.
 * <br> Когд один из коллег посылает сообщение на медиатор, то все коллеги получают сообщение от медиатора.
 */
class Main {
    public static void main(String[] args) {
        var mediator = new ConcreteMediator();

        var colleagueA = new ConcreteColleague(mediator, "colleagueA");
        var colleagueB = new ConcreteColleague(mediator, "colleagueB");
        var colleagueC = new ConcreteColleague(mediator, "colleagueC");

        mediator.addColleague(colleagueA);
        mediator.addColleague(colleagueB);
        mediator.addColleague(colleagueC);

        colleagueA.changeStatus();
        printDivide();
        colleagueB.changeStatus();
        printDivide();
        colleagueC.changeStatus();
    }

    private static void printDivide() {
        System.out.println("----------------------------");
    }
}

interface Mediator {
    void requestAll(Colleague colleague);
}

class ConcreteMediator implements Mediator {
    private final List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    /**
     * Устанавливает статус аргумента в {@code true}, а статус других {@link #colleagues} переводит в {@code false}
     */
    @Override
    public void requestAll(Colleague colleague) {
        colleague.setTrue();
        colleagues.stream()
                .filter(obj -> obj != colleague)
                .forEach(Colleague::setFalse);
    }
}

interface Colleague {
    void setFalse();

    void setTrue();

    void changeStatus();

}

class ConcreteColleague implements Colleague {
    private boolean status;
    private final Mediator mediator;
    private final String name;


    public ConcreteColleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println(name + " status is false");

    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println(name + " status is true");

    }

    @Override
    public void changeStatus() {
        mediator.requestAll(this);
    }
}