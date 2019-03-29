package LaiOffer.MyIterators;

import java.util.Iterator;

/**
 * Created by matinaju on 6/19/17.
 */
public class PeekIteratorII implements Iterator<Integer> {
    private Integer nextItem;
    private Iterator<Integer> ite;

    public PeekIteratorII(Iterator<Integer> iterator) {
        ite = iterator;
        if (ite.hasNext()) {
            nextItem = ite.next();
        }// initialize any member here.
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextItem;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = nextItem;
        nextItem = ite.next();
        return result;
    }

    @Override
    public boolean hasNext() {
        return nextItem != null;
    }
}
