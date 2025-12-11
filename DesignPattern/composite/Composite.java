package composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    String name;
    List<Component> subCompList = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public boolean addComponent(Component component){
        this.subCompList.add(component);
        return true;
    }

    @Override
    public int getPrice() {
        int price = 0;
        for(Component component: subCompList){
            price+= component.getPrice();
        }
        return price;
    }
}
