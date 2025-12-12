package Ch_05_Bit_Manupilation;

import java.util.ArrayList;

public class FlipAndWinV1 {

	
	static int  findLogestSequence(ArrayList<Integer> sequences) {
		
		int maxones=Integer.MIN_VALUE;
		
		for(int freq0=0;freq0<sequences.size();freq0+=2) {
			
			int onesSeqRight=(freq0-1)>=0?sequences.get(freq0-1):0;
			int onesSeqLeft=(freq0+1)<sequences.size()?sequences.get(freq0+1):0;

			int thisSeq=0;
			if(sequences.get(freq0)==1)
				thisSeq=onesSeqLeft+onesSeqRight;
			else if(sequences.get(freq0)>0)
				thisSeq=Math.max(onesSeqRight, onesSeqLeft);
			else		//sequences.get(freq0)==0
				thisSeq=onesSeqRight;
			
			maxones=Math.max(maxones, thisSeq);
		}
		return maxones+1;
	}
	
	static int logestSequence(int n) {
		if(n==-1) return Integer.BYTES*8;
		
		ArrayList<Integer> sequences=getAlternateSequence(n);
		for(int i:sequences) {
			System.out.print(i+" ");
		}
		System.out.println();
		return findLogestSequence(sequences);
	}
	
	static ArrayList<Integer> getAlternateSequence(int n){
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		boolean isCurrentOne=(n&1)==1?true:false;
		
		if(isCurrentOne) {
			al.add(0);
		}
		int prev=(n&1);
		n=n>>1;
		int count=1;
		while(n>0) {
		
			if((n&1)==prev) {
				count++;
			}else {
				al.add(count);
				count=1;
				
			}
			prev=(n&1);
			n=n>>1;
		
		}
		al.add(count);
		return al;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N=1775;
		System.out.println(Integer.toBinaryString(N));
		
		System.out.println(logestSequence(N));
		

	}

}
