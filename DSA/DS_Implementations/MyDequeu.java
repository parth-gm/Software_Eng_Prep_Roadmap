package gfg;

public class MyDequeu {
	
	int arr[];
	int front,rear,size;
	static final int MAX=100;
	public MyDequeu(int size)
	{
		arr=new int[MAX];
		front=-1;
		rear=0;
		this.size=size;
	}
	
	void insertFront(int x){
		
		if(isFull()) {
			System.out.println("Size exceeded");
			return;
		}
		
		if(front==-1)
		{
			front=0;
			rear=0;
		}else if(front==0) {
			front=size-1;
		}else {
			front--;
		}
		arr[front]=x;
		
		
	}
	
	void insertRear(int x) {
		if(isFull()) {
			System.out.println("Size exceeded");
			return;
		}
		
		if(front==-1) {
			front=0;
			rear=0;
		}else if(rear==size-1) {
			rear=0;
		}else {
			rear++;
		}
		arr[rear]=x;
		
	}
	
	int deleteFront() {
		
		if(isEmpty()) {
			System.out.println("Underflow not able to delete");
			return Integer.MAX_VALUE;
		}
		int val=arr[front];
		
		if(front==rear) {
			
			front=-1;
			rear=-1;
		}
		else {
		
			if(front==size-1) {
				front=0;
			}else {
				front++;
			}
		}
		return val;
	}
	
	int deleteRear() {
		if(isEmpty()) {
			System.out.println("Underflow not able to delete");
			return Integer.MAX_VALUE;
		}
		int val=arr[rear];
		
		if(front==rear) {
			
			front=-1;
			rear=-1;
		}
		else {
		
			if(rear==0) {
				rear=size-1;
			}else {
				rear--;;
			}
		}
		return val;
	}
	
	boolean isFull()
	{
		return (front==0 && rear==size-1) || (front==rear+1);
	}
	
	boolean isEmpty()
	{
		return front==-1;
	}
	
	
	public static void main(String[] args) {
		

		MyDequeu dq = new MyDequeu(5); 
          
        System.out.println("Insert element at rear end  : 5 "); 
        dq.insertRear(5); 
          
        System.out.println("insert element at rear end : 10 "); 
        dq.insertRear(10); 
//          
//        System.out.println("get rear element : "+ dq.getRear()); 
          
        
        System.out.println("After delete rear element new rear become : " +  
        		dq.deleteRear()); 
          
        System.out.println("inserting element at front end"); 
        dq.insertFront(15); 
          
        
          
        
          
        System.out.println("After delete front element new front become : " + 
                                   +  dq.deleteFront()); 
		
		
	}
	
}
