package leetcode_july;

public class ReverseBits {

	public static int reverseBits(int n) {
    
		StringBuffer sb=new StringBuffer();
		int no=0;
		while(n>0) {
			sb.append(n&1);
			n=n>>1;
		}
		int len=sb.length()-1;
		
		while((len)>=0) {
			no=(int) (no+Math.pow(2, len));
			len--;
		}
		return no;
			
	}

	
	public static void main(String[] args) {
		
		reverseBits(256);

	}

}
