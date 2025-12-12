package Ch_05_Bit_Manupilation;

public class FlipAndWin {
	
	
	
	
	
	
	
	
	
	static int getMaxOneAround(int N,int count) {
		int no=N;
		int leftMask=1<<(count-1);
		//System.out.println("leftmask "+leftMask);
		int rightMask=1<<(count+1);
		//System.out.println("rightmask "+rightMask);
		int leftOnes=0,rightOnes=0;
		while(leftMask>=1 && count>0) {
			if((leftMask & no)!=0)
			{
				leftOnes++;
			}else {
				break;
			}
			leftMask=leftMask>>1;
		}
		
		while(rightMask!=0) {
			if((rightMask & no)!=0)
			{
				rightOnes++;
			}
			else 
			{
				break;
			}
			rightMask=rightMask<<1;
		}
		
		return leftOnes+rightOnes+1;
		
	}
	
	static int findMaxOnes(int N) {
		
		if(N==0)return 1;
		
		int index=0;
		int max=Integer.MIN_VALUE;
		int no=N;
		
		while(no>0) {
			int bit=no&1;
			System.out.println("bit "+ bit +" index "+index+" get max one around "+getMaxOneAround(N, index));
			max= (bit==0)?Math.max(max, getMaxOneAround(N, index)):max;
			index++;
			no=no>>1;
		}
		return max;
		
	}
	
	public static void main(String[] args) {
		
		int N=754;
		System.out.println(Integer.toBinaryString(N));
		
		System.out.println(findMaxOnes(N));
//		System.out.println(4>>3);
		
		
	}
	

}
