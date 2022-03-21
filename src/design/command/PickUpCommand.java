package design.command;

public class PickUpCommand implements Command{

    /**
     * Create concrete classes
     */

    @Override
    public void execute() {
        ROBOT.pickup();
    }
}
