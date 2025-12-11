package composite;

public class MainDemo {

    public static void main(String[] args) {
        Component hd = new Leaf("HD", 20000);
        Component ram = new Leaf("HD", 10000);

        Composite parent = new Composite("cpu");
        parent.addComponent(hd);
        parent.addComponent(ram);
        System.out.println(parent.getPrice());

    }
}
