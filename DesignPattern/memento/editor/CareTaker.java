package memento.editor;

import java.util.Stack;

public class CareTaker {
    private final Stack<EditorMemento> editorMementos = new Stack<>();

    public void saveEditorVersion(Editor editor){
        editorMementos.push(editor.saveState());
    }

    public void undoEditorVersion(Editor editor){
        if(!editorMementos.isEmpty()){
            editor.restoreState(editorMementos.pop());
        }
    }
}
