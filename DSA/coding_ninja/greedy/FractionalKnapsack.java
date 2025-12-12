package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		Knapsack[] ksc = new Knapsack[N];
		
		
		for(int i=0;i<N;i++) {
			
			ksc[i] = new Knapsack(sc.nextInt(), sc.nextInt());
			
		}
		Arrays.sort(ksc, new Comparator<Knapsack>(){

			@Override
			public int compare(Knapsack arg0, Knapsack arg1) {
				
				float ratio1 = (float)arg0.value/arg0.weight;
				float ratio2 = (float)arg1.value/arg1.weight;
				if(ratio2>ratio1)
					return 1;
				return -1;
			}
			
		});
//		for(Knapsack k:ksc) {
//			System.out.println(k);
//		}
//		System.out.println();
		
		int currentWeight = 0;
		double value = 0;
		int index = 0;
		while((index<N) && (currentWeight + ksc[index].weight)<W) {
			currentWeight += ksc[index].weight;
			value += ksc[index].value;
			index++;
			
		}
		if(W>currentWeight && index<N) {
			value += ((double)ksc[index].value*(W-currentWeight))/ksc[index].weight;
		}
	    System.out.println(
	    	      String.format("%.6f", value));
	    	  
		
	}

}

class Knapsack{
	int value, weight;
	
	public Knapsack(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
	public String toString() {
		return "Value: "+this.value + "Weight: "+this.weight + "Ration: "+((float)this.value/this.weight);
	}
}