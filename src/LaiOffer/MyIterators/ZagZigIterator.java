package LaiOffer.MyIterators;

import java.util.Iterator;
import java.util.List;

/**
 * Created by matinaju on 6/17/17.
 */
public class ZagZigIterator implements Iterator<Integer> {
    int listIndex;
    Integer nextItem;
    List<Iterator<Integer>> listIterators;

    public ZagZigIterator(List<Iterator<Integer>> input) {
        listIndex = 0;
        listIterators = input;
        nextItem = null;
    }

    @Override
    public boolean hasNext() {
        if (nextItem != null) {
            return true;
        }
        while (!listIterators.isEmpty()) {
            if (listIndex >= listIterators.size()) {
                listIndex = 0;
            }
            Iterator<Integer> nextIterator = listIterators.get(listIndex);
            if (nextIterator.hasNext()) {
                nextItem = nextIterator.next();
                listIndex++;
                return true;
            } else {
                listIterators.remove(listIndex);
            }
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
