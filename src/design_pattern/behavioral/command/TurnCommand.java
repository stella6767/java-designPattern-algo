package design_pattern.behavioral.command;

public class TurnCommand implements Command {

    Robot.Direction direction;

    private Robot robot;


    public TurnCommand(Robot.Direction direction, Robot robot) {
        this.direction = direction;
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.turn(direction);
    }

    @Override
    public void undo() {
        robot.turn(Robot.Direction.RIGHT);
    }
}
