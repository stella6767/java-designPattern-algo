package design.command;

public class MoveForwordCommand implements Command{

    int space;


    public MoveForwordCommand(int space) {
        this.space = space;
    }

    @Override
    public void execute() {
        ROBOT.moveForward(space);
    }


}
