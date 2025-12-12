package Sorting;

import java.util.Arrays;

public class MInIntHeap {

    private int capacity=10;
    private int size=0;

    int[] items=new int[capacity];

    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }

    private int getParentIndex(int childindex){
        return (childindex-1)/2;
    }
    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<size;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }

    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }


    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private int parent(int index){
        return items[getParentIndex(index)];
    }
    private void ensureExtraCapacity(){
        if(size==capacity){
            items= Arrays.copyOf(items,capacity*2);
            capacity*=2;
        }
    }

    public int peek(){
        if(size==0) throw new IllegalStateException();
        return items[0];
    }

    public int poll(){
        if(size==0) throw new IllegalStateException();
        int item=items[0];
        items[0]=items[size-1];
        size--;
        heapifyDown();
        return item;

    }

    public void add(int item){
        ensureExtraCapacity();
        items[size]=item;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int currentItemIndex=size-1;
        while(hasParent(currentItemIndex) && parent(currentItemIndex)>items[currentItemIndex]){
            swap(currentItemIndex,getParentIndex(currentItemIndex));
            currentItemIndex=getParentIndex(currentItemIndex);
        }

    }

    public void heapifyDown(){
        int index=0;
        while(hasLeftChild(index)){
            int smallerChildIndex=getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index)<leftChild(index)){
                smallerChildIndex=getRightChildIndex(index);
            }
            if(items[smallerChildIndex]>items[index]){
                break;
            }
            else{
                swap(smallerChildIndex,index);
            }
            index=smallerChildIndex;
        }
    }

    private void swap(int index1,int index2){
        int temp=items[index1];
        items[index1]=items[index2];
        items[index2]=temp;
    }




}
