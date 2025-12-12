package graph2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDistinct<E> extends PriorityQueue<E>  {

	public PriorityQueueDistinct(Comparator<? super E> comparator) {
        super(comparator);
    }
	@Override
	public boolean add(E e) {
		
		if(super.contains(e)) {
			super.remove(e);
		}
		
		return super.add(e);
	}
}
