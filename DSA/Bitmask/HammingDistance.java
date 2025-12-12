package leetcode_july;

public class HammingDistance {

	static StringBuffer convertToBinary(int dec) {
		
		StringBuffer sb=new StringBuffer();
				
		while(dec>0) {
			int val=dec%2;
			sb.append(val);
			dec=dec/2;
		}
		return sb;
		
	}
	
	static int findHammingDist(int x,int y) {
		
		StringBuffer bx=convertToBinary(x);
		StringBuffer by=convertToBinary(y);
		
		
		if(bx.length()<by.length()) {
			while(bx.length()<by.length()) {
				bx.append("0");
			}
		}else {
			while(by.length()<bx.length()) {
				by.append("0");
			}
		}
		int count=0;
		for(int i=0;i<by.length();i++) {
			if(bx.charAt(i)!=by.charAt(i))
				count++;
		}
		
		return count;
		
	}
	
	static int findHammingDistv2(int x,int y) {
		int count=0;
		while(x>0 || y>0) {
			if((x&1)!=(y&1))
				count++;
			x=x>>1;
			y=y>>1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		//System.out.println(findHammingDist(1,4));
		System.out.println(findHammingDistv2(5,4));
		//System.out.println(convertToBinary(12));
	}

}
