package design_pattern.behavioral.command;

public class MoveForwordCommand implements Command{

    int space;

    private Robot robot;


    public MoveForwordCommand(int space, Robot robot) {
        this.space = space;
        this.robot = robot;
    }

    @Override
    public void execute() {
        robot.moveForward(space);
    }

    @Override
    public void undo() {

    }


}
