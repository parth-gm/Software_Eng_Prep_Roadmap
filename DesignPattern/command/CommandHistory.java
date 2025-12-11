package command;

import java.util.Stack;

public class CommandHistory {

    private Stack<Command> commandHistory;

    CommandHistory(){
        commandHistory = new Stack<>();
    }

    public void push(Command command){
        this.commandHistory.push(command);
    }

    public Command pop(){
        return this.commandHistory.pop();
    }

    public boolean isEmpty(){
        return this.commandHistory.isEmpty();
    }

}
