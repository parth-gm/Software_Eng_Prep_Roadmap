package code;
import java.util.*;

public class FlattenList {

	static ArrayList<Integer> resultantLs = new ArrayList<>();
	static void getFlattenList(ArrayList outerls){
		
		for(int i=0;i<outerls.size();i++){
			Object obj = outerls.get(i);
			if(obj.getClass()==Integer.class){
				resultantLs.add((Integer)obj);
			}else{
				getFlattenList((ArrayList)obj);
			}
	
		}
		
	}

	//[1, [2, 3, [4]]]
	public static void main(String[] args) {
		
		ArrayList inputList = new ArrayList<>();
		inputList.add(1);
		ArrayList subList = new ArrayList<>();
		subList.add(2);
		subList.add(3);
		ArrayList subSubList = new ArrayList<>();
		subSubList.add(4);
		subList.add(subSubList);
		inputList.add(subList);
		
		getFlattenList(inputList);
		
		System.out.println(resultantLs);
		
	}

}
