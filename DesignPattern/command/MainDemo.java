package command;

public class MainDemo {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setTextField("abcdefghi");
        editor.executeCommand(new CutCommand(editor));
        System.out.println("Clipboard: "+editor.clipBoard);
        System.out.println("Text field: "+editor.textField);
        editor.executeCommand(new PasteCommand(editor));
        System.out.println("Clipboard: "+editor.clipBoard);
        System.out.println("Text field: "+editor.textField);
        editor.undo();
        System.out.println("Clipboard: "+editor.clipBoard);
        System.out.println("Text field: "+editor.textField);

    }
}
