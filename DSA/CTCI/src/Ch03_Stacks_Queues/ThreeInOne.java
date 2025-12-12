package Ch03_Stacks_Queues;

public class ThreeInOne {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int arrsizes[]= {5,3,5};
		MultiStack stacks=new MultiStack(3,  arrsizes);
		try {
			stacks.push(1, 1);
			stacks.push(1, 2);
			stacks.push(1, 3);
			stacks.push(1, 4);
		
			stacks.push(2, 5);
			stacks.push(2, 6);
			
			stacks.push(3, 7);
			stacks.push(3, 8);
			stacks.push(3, 9);
			stacks.push(3, 10);
			
			stacks.printStacks();
				
			int x=stacks.pop(1);
			System.out.println("popped"+x);
			stacks.printStacks();
			
			stacks.push(1, 4);
			stacks.push(1, 5);
			
			stacks.printStacks();
			
			stacks.pop(1);
			stacks.pop(1);
			stacks.pop(1);
			stacks.pop(1);
			stacks.pop(1);

			stacks.printStacks();
			
			
			stacks.push(2, 7);
			
			stacks.printStacks();
			
			
			stacks.pop(2);
			//stacks.pop(2);
			
	
			
			stacks.printStacks();
			
			stacks.pop(2);
			
			stacks.printStacks();
			
			stacks.pop(2);
			
			stacks.printStacks();
			
			stacks.push(3, 11);
			stacks.printStacks();
			
			stacks.pop(3);
			stacks.pop(3);
			stacks.pop(3);
			stacks.pop(3);
			stacks.printStacks();
			
			stacks.pop(3);
			stacks.printStacks();
			
			stacks.push(1, 3);
			stacks.push(2, 4);
			stacks.push(3, 6);
			
			stacks.printStacks();
			
			
			stacks.push(1, 3);
			stacks.push(2, 4);
			stacks.push(3, 6);
			
			stacks.printStacks();
			
			stacks.push(1, 3);
			stacks.push(2, 4);
			stacks.push(3, 6);
			
			stacks.printStacks();
			
			stacks.pop(2);
			stacks.printStacks();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
