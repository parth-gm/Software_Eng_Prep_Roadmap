package memento.editor;

public class MainDemo {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Editor editor = new Editor();
        editor.setText("ABC");
        careTaker.saveEditorVersion(editor);
        editor.setText(" EFG");
        careTaker.saveEditorVersion(editor);
        editor.setText(" HIJ");
        careTaker.saveEditorVersion(editor);
        editor.setText(" LMN");
        careTaker.saveEditorVersion(editor);


        careTaker.undoEditorVersion(editor);
        System.out.println(editor.getText());

        careTaker.undoEditorVersion(editor);
        System.out.println(editor.getText());

        careTaker.undoEditorVersion(editor);
        System.out.println(editor.getText());

        careTaker.undoEditorVersion(editor);
        System.out.println(editor.getText());



    }
}
