package coding.MyIterators;

import java.util.Iterator;
import java.util.List;

/**
 * Created by matinaju on 6/19/17.
 */
public class ZagZigIteratorII implements Iterator<Integer> {
    private int listIndex;
    private Integer nextItem;
    private int tempCount;
    private List<Iterator<Integer>> iteratorsList;

    public ZagZigIteratorII(List<Iterator<Integer>> input) {
        listIndex = 0;
        iteratorsList = input;
        nextItem = null;
    }

    @Override
    public boolean hasNext() {
        if (nextItem != null) {
            return true;
        }
        tempCount = iteratorsList.size();
        while (tempCount > 0) {
            if (listIndex >= iteratorsList.size()) {
                listIndex = 0;
            }
            Iterator<Integer> nextIterator = iteratorsList.get(listIndex++);
            if (nextIterator.hasNext()) {
                nextItem = nextIterator.next();
                return true;
            } else {
                tempCount--;
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
