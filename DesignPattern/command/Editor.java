package command;

public class Editor {
    public String textField;
    public String clipBoard;
    public CommandHistory commandHistory = new CommandHistory();

    public String getTextField() {
        return textField;
    }

    public String getClipBoard() {
        return clipBoard;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public void setClipBoard(String clipBoard) {
        this.clipBoard = clipBoard;
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            this.commandHistory.push(command);
        }
    }
    public void undo(){
        if(this.commandHistory.isEmpty()) return;
        Command cmd = this.commandHistory.pop();
        cmd.undo();
    }



}
