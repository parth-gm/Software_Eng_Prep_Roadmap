package command;

public class CutCommand extends Command{


    public CutCommand(Editor editor){
        super(editor);
    }
    @Override
    public boolean execute() {
        backup();
        this.editor.setClipBoard(this.editor.getTextField());
        this.editor.setTextField("");
        return true;
    }
}
