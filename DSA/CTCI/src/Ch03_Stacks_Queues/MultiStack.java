package Ch03_Stacks_Queues;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MultiStack {
	private int noOfStacks;
	private int values[];
	private int sizes[];
	private int tops[];
	public MultiStack(int noOfStacks,int[] sizes) {
		int total=0;
		this.noOfStacks=noOfStacks;
		this.sizes=sizes;
		for(int size:sizes) total=total+size;
		this.values=new int[total];
		this.tops=new int[noOfStacks];
		Arrays.fill(this.tops, -1);
	}
	
	public void push(int stackNo,int value) throws FullStackException {
		if(isFull(stackNo)) {
			throw new FullStackException("Stack is Full......");
		}else {
			
			if(tops[stackNo-1]==-1)
				getinitializeTop(stackNo);
			else 
				tops[stackNo-1]--;
			
			values[tops[stackNo-1]]=value;
			System.out.println("Push: updated top of stack "+stackNo+" top "+this.tops[stackNo-1]);
		}
		
	}
	
	public void getinitializeTop(int stackNo) {
		int t=0;
		for(int i=0;i<stackNo;i++) {
			t=t+this.sizes[i];
		}
		this.tops[stackNo-1]=t-1;
	}
	
	
	public int pop(int stackNo) throws CustomEmptyStackException{
		int item;
		if(isEmpty(stackNo)) {
			throw new CustomEmptyStackException("Empty.........");
		}else {
			item=this.values[tops[stackNo-1]];
			this.values[tops[stackNo-1]++]=0;
			if(isEmptyNext(stackNo)) this.tops[stackNo-1]=-1;
			System.out.println("Pop: updated top of stack "+stackNo+" top "+this.tops[stackNo-1]);
		}
		
		return item;
	}
	
	
	public boolean isEmptyNext(int stackNo) {
	
		int boundry=0;
		for(int i=0;i<stackNo;i++) {
			boundry=boundry+this.sizes[i];
		}
		return boundry==(tops[stackNo-1]);
	}
	
	public int peek(int stackNo) throws CustomEmptyStackException {
		int item;
		if(isEmpty(stackNo)) {
			throw new CustomEmptyStackException();
		}
		item=values[tops[stackNo-1]];
		return item;
	}
	
	public boolean isFull(int stackNo) {
		if(stackNo==1)return tops[stackNo-1]==0;
		int end=0;
		for(int i=0;i<stackNo-1;i++) {
			end=end+this.sizes[i];
		}
		
		return tops[stackNo-1]==end-1;
	}
	
	public boolean isEmpty(int stackNo) {
		if(tops[stackNo-1]==-1)return true;
		return false;
	}
	
	public void printStacks() {
		System.out.println("Printing....");
		for(int i=0;i<values.length;i++)
		{
			System.out.print(values[i]+" ");
		}
		
	}

}
