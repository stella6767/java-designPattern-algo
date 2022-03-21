package design.command;

import java.util.ArrayList;
import java.util.List;

public class RobotKit {

    /**
     * Create command invoker class.
     */

    private List<Command> commands;

    public RobotKit() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void start(){

        for (Command command : commands) {

            command.execute();
        }
    }


}
