package LaiOffer.MyIterators;

import java.util.Iterator;

/**
 * Created by matinaju on 6/19/17.
 */
public class PeekIterator implements Iterator<Integer> {
    private Integer nextItem;
    private Iterator<Integer> ite;

    public PeekIterator(Iterator<Integer> input) {
        nextItem = null;
        ite = input;
    }

    public Integer peek() {
        if (nextItem == null) {
            hasNext();
        }
        return nextItem;
    }

    @Override
    public boolean hasNext() {
        if (nextItem != null) {
            return true;
        }
        if (ite.hasNext()) {
            nextItem = ite.next();
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Integer result = nextItem;
            nextItem = null;
            return result;
        }
        return null;
    }
}
