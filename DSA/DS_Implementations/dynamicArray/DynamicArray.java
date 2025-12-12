package dynamicArray;

import java.util.Arrays;
import java.util.Iterator;

//@SuppressWarnings("unchecked")
public class DynamicArray <T> implements Iterable<T> {

	private T arr[];
	private int len = 0;
	private int capacity = 0;
	
	public DynamicArray(){
		this(16);
	}
	
	public DynamicArray(int capacity) {
		if(capacity<0) throw new IllegalArgumentException("Illegal Capacity"+capacity);
		this.capacity =capacity;
		
		arr = (T[])new Object[this.capacity];
	}
	
	public int size() {
		return len;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public T get(int index) {return arr[index];}
	public void set(int index, T ele) { arr[index]=ele;}
	
	
	public void clear() {
		for(int i=0;i<this.len;i++) {
			arr[i]=null;
		}
		len=0;
	}
	
	public void add(T ele) {
		if((len+1)>=capacity) {
			capacity = 2*capacity;
			if(capacity==0){
				capacity=1;
			}
				
			T arrNew[] = (T[])new Object[capacity];
			for(int i=0;i<len;i++)
				arrNew[i]=arr[i];
			arr = arrNew;
		}
		arr[len++] = ele;
		
	}
	
	public T removeAt(int index) {
		if(index>=len || index<0)
			throw new IndexOutOfBoundsException();
			
		T ele = arr[index];
		
		if((len-1)==(capacity/2)) {
			T arrNew[] = (T[]) new Object[len-1];
			capacity=(len-1);
			for(int i=0,j=0;i<len;i++) {
				if(index!=i)
				{
					arrNew[j++]=arr[i];
				}
			}
			arr = arrNew;
		}else {
			for(int i=0, j=0;i<len;i++,j++) {
				if(index==i) j--;
				else{
					arr[j]=arr[i];
				}
			}
			arr[len-1]=null;
			
		}
		len--;	
		return ele;
		
	}
	
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if(index==-1) return false;
		removeAt(index);
		return true;
	}
	
	public int indexOf(Object obj) {
		for(int i=0;i<len;i++) {
			if(obj==null)
			{
				if(arr[i]==null) return i;
			}else if(obj.equals(arr[i]))
				{return i;}
		}
		return -1;
	}
	
	public boolean contains(Object obj) {
		return indexOf(obj)!= -1;
	}

	@Override
	public String toString() {
		if(len==0)
			return "[]"+" Capacity="+ capacity+ "| Length="+len;
		else {
			StringBuilder sb =new StringBuilder().append("[");
			for(int i=0;i<len-1;i++)
				sb.append(arr[i]+ ", ");
			return sb.append(arr[len-1]+" ]"+" Capacity="+ capacity+ "| Length="+len).toString();
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DynamicArrayIterator<>();
	}
	
	private class DynamicArrayIterator<T> implements Iterator<T>{
		private int index=0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			if(index<len) return true;
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return (T) arr[index++];
		}
		
	}
	
	
}
