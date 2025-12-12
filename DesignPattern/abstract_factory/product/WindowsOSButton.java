package abstract_factory.product;

public class WindowsOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("WindowsOSButton Button paint");
    }
}
