package roykar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LowestNosSumToK {

	
	static boolean checkSum(int[] subSeqs,int indexSeq,int reqSum) {
		
		int sum=0;
		boolean isEqualK=false;
		for(int i=0;i<indexSeq;i++) {
			sum=sum+subSeqs[i];
		
		}
		if(sum==reqSum){
			isEqualK=true;
		}
		
		return isEqualK;
		
	}
	
	static void findLowestNosReqSumHelper(int[] arr,int indexArr,int[] subSeqs,int indexSeq,int reqSum,List<List<Integer>> ansList){
       
		
		if (indexArr>=arr.length) {
			
			if(checkSum(subSeqs, indexSeq,reqSum)) {
				
				List<Integer> one=new ArrayList<Integer>();
				for(int i=0;i<indexSeq;i++) {
					one.add(subSeqs[i]);
				}
				ansList.add(one);
			}
            return ;
        }
		
		
		findLowestNosReqSumHelper(arr, indexArr+1,subSeqs,indexSeq,reqSum,ansList);
		subSeqs[indexSeq]=arr[indexArr];
		findLowestNosReqSumHelper(arr, indexArr+1,subSeqs,indexSeq+1,reqSum,ansList);

    }

	static List<Integer> findLowestNosReqSum(int[] arr,int reqSum){
	
		List<List<Integer>> ansList=new ArrayList<List<Integer>>();
		int[] subSeqs=new int[arr.length];
		findLowestNosReqSumHelper(arr, 0, subSeqs, 0, reqSum, ansList);
		List<Integer> lowestList=null;
		int minSize=Integer.MAX_VALUE;
		for(List<Integer> ll:ansList) {
			if(!ll.isEmpty() && ll.size()<minSize) {
				minSize=ll.size();
				lowestList=ll;
			}
		}
		if(minSize==Integer.MAX_VALUE)
		{
			System.out.println("Given K value sum is not found in array: return null");
			
		}
		return lowestList;
		
	
	}
	
	
	public static void main(String[] args) {
		
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter No of elements in array: ");
			int N=sc.nextInt();//Nos of element in array
			int[] arr=new int[N];
			System.out.println("Enter elements in array: ");
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();	//input element
			}
			System.out.println("Enter No of testcases: ");
			int testNo=sc.nextInt(); //No of testcase test for required Sum
			System.out.println("Enter required sum to test for above array: ");
			for(int j=0;j<testNo;j++) {
				int reqSum=sc.nextInt();
				System.out.println(findLowestNosReqSum(arr,reqSum));	
			}
		}
		

	}

}
