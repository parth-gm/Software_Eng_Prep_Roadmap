package solid_principle_test;

public class Booking {

	String memberName;
	Ipayment paymentMethod;
	
	public Booking(String name, Ipayment payIpayment) {
		this.memberName = name;
		
		this.paymentMethod = payIpayment;
	}
	
	void savePaymentDetails() {
		paymentMethod.savePaymentDetails();
	}
	// Animal dog = new Dog();
	//dog.makeNoise();
	//dog.dogBark();
	

}
