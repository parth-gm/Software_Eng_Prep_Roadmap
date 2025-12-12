package Ch_05_Bit_Manupilation;

public class BinaryToString {

	static String realToBinary(double realNo) {
		
		if(realNo>=1 && realNo<=0) return "Invalid Parameter Pass";
		
		
		
		StringBuffer sb=new StringBuffer();
		sb.append('.');
//		String afterDecimal=String.valueOf(realNo);
//		int afterDecimalInt=Integer.parseInt(afterDecimal.substring(afterDecimal.indexOf('.')));

		int count=0;
		double currentRealNo=realNo;
		while(currentRealNo!=1 && count<32) 
		{
			currentRealNo=currentRealNo>1?((currentRealNo-1)*2):(currentRealNo)*2;
			sb.append((int)currentRealNo);
			count++;
		}
		if(count==32) return "ERROR";
		
		return sb.toString();
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double realNo=0.125;
		System.out.println(realToBinary(realNo));
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = realToBinary(num);
			String binary2 = realToBinary(num);
			if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
				System.out.println(num + " : " + binary + " " + binary2);
			}
		}
	}

}
