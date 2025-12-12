package Sorting;

public class HeapSort {

    public static void main(String[] args) {
        MInIntHeap mh=new MInIntHeap();
        mh.add(9);
        mh.add(12);
        mh.add(11);
        mh.add(7);
        mh.poll();
        System.out.println(mh.peek());

    }
}
