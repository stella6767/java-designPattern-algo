package design_pattern.behavioral.memento;

public class Memento {

    /**
     * first step
     */

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
