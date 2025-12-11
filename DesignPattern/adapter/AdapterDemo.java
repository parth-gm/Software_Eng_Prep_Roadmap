package adapter;

public class AdapterDemo {

    public static void main(String[] args) {
        RegularSocket regularSocket = new RegularSocket(3);
        RegularCharger regularCharger = new RegularCharger(3);
        System.out.println(regularSocket.fits(regularCharger));

        IOSCharger iosCharger = new IOSCharger();
        SocketAdapter socketAdapter = new SocketAdapter(iosCharger);
        System.out.println(regularSocket.fits(socketAdapter));
    }
}
