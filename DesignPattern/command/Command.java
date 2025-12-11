package command;

public abstract class Command {
    public Editor editor;
    private String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public void backup(){
        this.backup =   editor.getTextField();
    }

    public void undo(){
        editor.setTextField(backup);
    }
    public abstract boolean execute();
}
