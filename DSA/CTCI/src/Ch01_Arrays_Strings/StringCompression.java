package Ch01_Arrays_Strings;

public class StringCompression {

	static String doCompression(String str) {
		StringBuffer compressed=new StringBuffer();
		int count=1;
		
		for(int i=0;i<str.length()-1;i++)
		{
			if(str.charAt(i)==str.charAt(i+1)) {
				count++;
			}else {
				compressed.append(str.charAt(i));
				compressed.append(count);
				count=1;
			}
				
		}
		compressed.append(str.charAt(str.length()-1));
		compressed.append(count);
		return str.length()>compressed.toString().length()?compressed.toString():str; 
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(doCompression("aabcde"));
	}

}
