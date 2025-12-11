package memento.editor;

final class EditorMemento {
    private String text;
    EditorMemento(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
