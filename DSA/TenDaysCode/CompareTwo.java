package TenDaysCode;

import java.util.Comparator;

public class CompareTwo implements Comparator<ObjectClass>{

	@Override
	public int compare(ObjectClass arg0, ObjectClass arg1) {
		// TODO Auto-generated method stub
		if(ObjectClass.compareType.equals("lexicographical"))
			return arg0.strs[ObjectClass.key-1].compareTo(arg1.strs[ObjectClass.key-1]);
		
		return 	Integer.parseInt(arg0.strs[ObjectClass.key-1])-Integer.parseInt(arg1.strs[ObjectClass.key-1]);
	
	}

	
}
