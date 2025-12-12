package practice;

public class UnionFind {

	static void intialize(int arr[], int n) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
		}
	}
	
	static boolean find(int arr[],int A,int B) {
		if(arr[A]==arr[B]) {
			return true;
		}else {
			return false;
		}
	}
	
	static void union(int arr[],int A,int B) {
		
		int temp=arr[A];
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==temp) {
				arr[i]=arr[B];
			}
		}
		
		
	}
	
	static boolean checkCycle(int[][] edges,int[] arr) {
		
		for(int i=0;i<edges.length;i++) {
			
			if(find(arr,edges[i][0],edges[i][1])) {
				return true;
			}
			else{
				union(arr,edges[i][0],edges[i][1]);
			}
			
		}
		return  false;
		
	}
			
	public static void main(String[] args) {
		
		int n=5;
		int arr[]=new int[n];
		intialize(arr, n);
		int e=5;
		int[][] edges= {{0,1},{0,2},{1,3},{3,4},{4,1}};
		System.out.println(checkCycle(edges,arr));
		
	}

}
