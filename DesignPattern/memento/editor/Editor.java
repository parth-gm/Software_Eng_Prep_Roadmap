package memento.editor;

public class Editor {
    private String text ="";

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text += text;
    }

    public EditorMemento saveState(){
        return new EditorMemento(this.text);
    }

    public void restoreState(EditorMemento editor){
        this.text = editor.getText();
    }

}
