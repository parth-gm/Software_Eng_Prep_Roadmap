package abstract_factory.product;

public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Windows checkbox paint");
    }
}
