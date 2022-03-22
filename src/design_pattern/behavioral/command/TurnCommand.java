package design_pattern.behavioral.command;

public class TurnCommand implements Command {

    Robot.Direction direction;

    public TurnCommand(Robot.Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute() {
        ROBOT.turn(direction);
    }
}
