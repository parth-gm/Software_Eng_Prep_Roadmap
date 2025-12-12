package dynamicArray;

public class DynamicArrayTest {

	public static void main(String[] args) {
		DynamicArray<String> da =new DynamicArray<>(4);
		da.add("A");
		da.add("B");
		da.add("C");
		System.out.println(da);
		da.add("D");
		da.add("E");
		System.out.println(da);
		da.remove("B");
		da.removeAt(0);
		da.remove("E");
		System.out.println(da);
		da.remove("C");
		System.out.println(da);
		da.remove("D");
		System.out.println(da);
		da.add("A");
		da.add("B");
		da.add("C");
		da.add("C");
		da.add(null);
		da.clear();
		System.out.println(da.indexOf(null));
		System.out.println(da.remove("B"));
		
		System.out.println(da.remove("Fdsf"));
		System.out.println(da);
		System.out.println(da.isEmpty());
		System.out.println(da.size());
		for(String str:da) {
			System.out.println(str);
		}
		
	}
}
	