package practice;

public class UnionFindv2 {

	

	static void intialize(int size[],int arr[], int n) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
			size[i]=1;
		}
		
	}
	
	static int root(int arr[],int i) {
		while(arr[i]!=i) {
			i=arr[i];
		}
		return i;
	}
	
	int root1(int Arr[ ] ,int i)
	{
	    while(Arr[ i ] != i)
	    {
	        Arr[ i ] = Arr[ Arr[ i ] ] ; 
	i = Arr[ i ]; 
	    }
	return i;
	}

	static boolean find(int arr[],int A,int B) {
		if(root(arr,A)==root(arr,B)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	static void union(int[] arr,int u,int v) {
		
		int rootu=root(arr,u);
		int rootv=root(arr,v);
		
		arr[rootu]=rootv;		
		
	}
	
	
	static void weightedUnion(int size[],int arr[],int u,int v){
		
		int rootu=root(arr,u);
		int rootv=root(arr,v);
		
		if(size[rootu]>size[rootv]) {
			arr[rootv]=rootu;
			size[rootu]=size[rootu]+size[rootv];
		}else {
			arr[rootu]=rootv;
			size[rootv]=size[rootu]+size[rootv];
		}
	
		
	}
	
	
	static boolean checkCycle(int size[],int[][] edges,int[] arr) {
		
		for(int i=0;i<edges.length;i++) {
			
			if(find(arr,edges[i][0],edges[i][1])) {
				return true;
			}
			else{
				//union(arr,edges[i][0],edges[i][1]);
				weightedUnion(size,arr,edges[i][0],edges[i][1]);
			}
			
		}
		return  false;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int n=5;
		int arr[]=new int[n];
		int size[]=new int[n];
		intialize(size,arr, n);
		int e=5;
		int[][] edges= {{0,1},{0,2},{1,3},{3,4},{4,1}};
		System.out.println(checkCycle(size,edges,arr));
	
		
	}

}
