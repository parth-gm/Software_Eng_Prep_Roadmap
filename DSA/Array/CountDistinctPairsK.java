package array;
import java.util.*;
public class CountDistinctPairsK {

	static int countPairsWithDiffK(int arr[], int k)
	{
			int n = arr.length;
			Arrays.sort(arr); // Sort array elements
//			int[] array = {1, 1, 2, 4, 5};
			//{5, 6, 10, 11, 11, 16} 
			HashSet<Pair> set = new HashSet<>();
			int l = 0;
			int r = 0;
			while(r < n)
			{
				if(l!=r && arr[r] - arr[l] == k)
				{
					set.add(new Pair(arr[r], arr[l]));
					l++;
					r++;
				}
				else if(arr[r] - arr[l] > k)
					l++;
				else
					r++;
			}
			System.out.println(set);
			return set.size();
	}
	
	public static class Pair{
		int a,b;
		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public boolean equals(Object obj) {
			Pair newPair = (Pair)obj;
			if((newPair.a == this.a) && (newPair.b==this.b))
				return true;
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.a + this.b;
		}
		
		public String toString() {
			return "("+a+","+b+")";
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 1, 1, 1, 1};
//		int[] array = {11, 6, 10, 5, 11, 16};
//		{5, 6, 10, 11, 11, 16} => {(16, 11), (10, 5)
		int k = 0;
		
		System.out.println(countPairsWithDiffK(array, k));

	}

}
