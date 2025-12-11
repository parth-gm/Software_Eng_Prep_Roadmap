package abstract_factory.creator;

import abstract_factory.product.Button;
import abstract_factory.product.Checkbox;
import abstract_factory.product.WindowsCheckbox;
import abstract_factory.product.WindowsOSButton;

public class WindowsOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
