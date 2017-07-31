package LaiOffer.MyIterators;

import java.util.Iterator;

/**
 * Created by matinaju on 6/19/17.
 */
public class PeekIteratorII implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> ite;

    public PeekIteratorII(Iterator<Integer> input) {
        ite = input;
        if (ite.hasNext()) {
            next = ite.next();
        }
    }

    public Integer peek() {
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        Integer result = next;
        next = ite.next();
        return result;
    }
}
