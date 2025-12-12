package solid_principle_test;

public class Client {

	public static void main(String[] args) {
		Ipayment cashP = new CashPayment();
		
		Booking b1 = new Booking("Abhinav", cashP);

		Ipayment cardP = new CardPayment();
		
		Booking b2 = new Booking("Abhinav", cardP);

	}

}
