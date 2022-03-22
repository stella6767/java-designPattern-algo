package design_pattern.behavioral.command;

public class CommandApp {

    /**
     * https://refactoring.guru/design-patterns/command
     */

    public static void main(String[] args) {
        RobotKit robotKit = new RobotKit();
        robotKit.addCommand(new MoveForwordCommand(2));
        robotKit.addCommand(new TurnCommand(Robot.Direction.LEFT));

        robotKit.start();
    }

}
