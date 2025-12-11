package command;

public class CopyCommand extends Command{


    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        this.editor.setClipBoard(this.editor.getTextField());
        return true;
    }
}
