package Ch03_Stacks_Queues;

public class StackMin_Main {

	public static void main(String[] args) {
		StackMin smin=new StackMin();
		StackMinV2 sminv2=new StackMinV2();
		int[] array = {3,2,1,10,6,7,4};
		for (int value : array) {
			smin.push(value);
			sminv2.push(value);
			System.out.print(value + ", ");
		}
		
		System.out.println('\n');
		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + smin.pop().value +"   "+ sminv2.pop() );
			System.out.println("New min is " + smin.min()+"  "+sminv2.min() );
		}
		
		
	}
	
}
