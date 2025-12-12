package abstract_factory.product;

public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("MacOS Button paint");
    }
}
