package abstract_factory.product;

public class MacOSCheckbox implements Checkbox
{
    @Override
    public void paint() {
        System.out.println("Macos checkbox paint");
    }
}
