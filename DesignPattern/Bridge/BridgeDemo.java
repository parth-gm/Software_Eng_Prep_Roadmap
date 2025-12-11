package Bridge;

public class BridgeDemo {

    public static void main(String[] args) {
        BasicRemote basicRemote = new BasicRemote(new TV());
        basicRemote.power();
        basicRemote.volumeDown();
    }

}
