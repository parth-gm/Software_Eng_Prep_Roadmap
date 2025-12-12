package abstract_factory.creator;

import abstract_factory.product.Button;
import abstract_factory.product.Checkbox;
import abstract_factory.product.MacOSButton;
import abstract_factory.product.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
