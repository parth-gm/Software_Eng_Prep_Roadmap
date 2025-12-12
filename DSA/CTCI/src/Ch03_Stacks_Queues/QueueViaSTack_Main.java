package Ch03_Stacks_Queues;

public class QueueViaSTack_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueViaStack<Integer> qs=new QueueViaStack<Integer>();
		
		qs.add(1);
		qs.add(2);
		qs.add(3);
		qs.add(4);
		
		int x=qs.remove();
		System.out.println(x);

		System.out.println(qs.remove());

		
		System.out.println(qs.peek());
		
	}

}
