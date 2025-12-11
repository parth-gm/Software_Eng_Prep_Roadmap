package command;

public class PasteCommand extends Command{

    public PasteCommand(Editor editor){
        super(editor);
    }

    @Override
    public boolean execute() {
        backup();
        this.editor.setTextField(this.editor.getClipBoard());
        return true;
    }
}
