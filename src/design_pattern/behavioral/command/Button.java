package design_pattern.behavioral.command;

import java.util.Stack;

public class Button {

    /**
     * Invoker
     */

    private Stack<Command> commands = new Stack<>();


    public void addCommand(Command command){
        this.commands.push(command);
    }

    public void press(Command command){
        command.execute();

    }

    public void allCommandStart(){
        for (Command command : commands) {
            command.execute();
        }
    }



    public void undo(){

        if (!commands.isEmpty()){
            Command command = commands.pop();
            command.undo();
        }

    }

}
