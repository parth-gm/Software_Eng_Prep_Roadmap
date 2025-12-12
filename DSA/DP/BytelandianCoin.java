package codechef;

import java.util.HashMap;
import java.util.Scanner;

public class Bytelandian {

    static long getMaxDollar(int coin) {
        if(coin<12) {
            return coin;
        }
        return Math.max((long)coin, getMaxDollar(coin/2)+getMaxDollar(coin/3)+getMaxDollar(coin/4));

    }

	//static int[] dp;
	static HashMap<Integer, Long> dp;
	static long getMaxDollar(int coin) {
		if(coin<12) return dp.get(coin);
		for(int i=12;i<=coin;i++)
			dp.put(i,Math.max(dp.get(i),(dp.get(i/2)+dp.get(i/3)+dp.get(i/4))));
		return dp.get(coin);
	}
	
	static void intializeDp(HashMap<Integer, Long> hm) {
		for(int i=0;i<12;i++)
			hm.put(i, (long) i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int byteCoin=sc.nextInt();
			dp=new HashMap<Integer,Long>();
			intializeDp(dp);
			System.out.println(getMaxDollar(byteCoin));
		}
	}

}
