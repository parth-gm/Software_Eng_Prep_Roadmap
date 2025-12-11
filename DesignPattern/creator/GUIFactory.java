package abstract_factory.creator;

import abstract_factory.product.Button;
import abstract_factory.product.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
