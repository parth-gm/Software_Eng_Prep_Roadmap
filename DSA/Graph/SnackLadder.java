package hashcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SnackLadder {

	 public static int snakesAndLadders(int[][] board) {
	     int[] board1D = new int[board.length*board[0].length];
	     int idx=0;
	     boolean flip=false;
		 for(int i=board.length-1;i>=0;i--) {
	    	 if(flip) {
				 for(int j=board[0].length-1;j>=0;j--) {
		    		 board1D[idx++] = board[i][j];
		    	 }
		
	    	 }else	{
	    		 for(int j=0;j<board[0].length;j++) {
		    		 board1D[idx++] = board[i][j];
		    	 }
	    	 }
	    	 flip=!flip;
	     }
		 
		 System.out.println(Arrays.toString(board1D));
		 int size = board.length*board[0].length;
		 System.out.println("SIZE: "+size);
		 ArrayList<Integer> trace = new ArrayList<>();
//		 trace.add(0);
		 return snakesAndLaddersHelper(board1D, 0, size, 0, trace);
	 }
	
	private static int snakesAndLaddersHelper(int[] board1d, int i, int size, int count, ArrayList<Integer> trace) {
		System.out.println("Val"+i);
//		System.out.println("Trace:"+trace);
		if(trace.contains(i)) {
			return Integer.MAX_VALUE;
		}else {
			trace.add(i);
		}
		System.out.println("Trace:"+trace);
		
		if(i>=size)
			return Integer.MAX_VALUE;
		
		if(i==(size-1)) {
			return count;
		}
		
		int minCount = Integer.MAX_VALUE;
		try {
			for(int step=1;step<=6;step++) {
				
				if((i+step)<size) {
					
					if(board1d[i+step]==-1) {
//						trace.add(i+step);
						minCount= Math.min(minCount, 
								snakesAndLaddersHelper(board1d,i+step, size, count+1, trace));
//						System.out.println("-1: "+(i+step));
//						System.out.println(trace);
//						trace.remove(new Integer(i+step));
					}
					else{
//						trace.add(board1d[i+step]-1);
						minCount= Math.min(minCount, 
								snakesAndLaddersHelper(board1d,board1d[i+step]-1, size, count+1, trace));
//						System.out.println("+ve: "+(board1d[i+step]-1));
//						System.out.println(trace);
//						trace.remove(new Integer(board1d[i+step]-1));
					}
				}
			}
		}catch(Exception e) {
			System.out.println(i);
			e.printStackTrace();
			
		}
		return minCount;
	}
	
	private static int snakesAndLaddersHelper2(int[] board1d, int i, int size, boolean isPrevJump) {
		if(i>=size)
			return Integer.MAX_VALUE;
		
		if(i==(size-1)) {
			return 0;
		}
		
		int minCount = Integer.MAX_VALUE;
		
		for(int step=1;step<=6;step++) {
			
			if(board1d[i]==-1) {
				minCount= Math.min(minCount, 
						1 +snakesAndLaddersHelper2(board1d,i+step, size, false));
			}
			else if(!isPrevJump) {
				minCount= Math.min(minCount, 
						1 + snakesAndLaddersHelper2(board1d,board1d[i]-1, size, true));
			}
		}
		
		return minCount;
	}
	

	public static void main(String[] args) {
		
//		int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
		int[][] board = {{-1,4,-1},{6,2,6},{-1,3,-1}};
		
		System.out.println(snakesAndLadders(board));
		
	}

}

//[[-1,-1,-1,-1,-1,-1],
// [-1,-1,-1,-1,-1,-1],
// [-1,-1,-1,-1,-1,-1],
// [-1,35,-1,-1,13,-1],
// [-1,-1,-1,-1,-1,-1],
// [-1,15,-1,-1,-1,-1]]
////////////////////////////		 
//[-1, 15, -1, -1, -1, -1, 
// -1, -1, -1, -1, -1, -1,
// -1, 35, -1, -1, 13, -1, 
// -1, -1, -1, -1, -1, -1, 
// -1, -1, -1, -1, -1, -1,
// -1, -1, -1, -1, -1, -1]

