package design_pattern.behavioral.observer.part2;

public class User implements Subscriber{

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void handleMessage(String msg) {
        System.out.println(msg);
    }
}
