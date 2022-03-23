package design_pattern.behavioral.command;

public class PickUpCommand implements Command{

    /**
     * Create concrete classes
     */
    private Robot robot;

    public PickUpCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.pickup();
    }

    @Override
    public void undo() {

    }
}
