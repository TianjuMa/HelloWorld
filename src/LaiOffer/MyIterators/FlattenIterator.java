package LaiOffer.MyIterators;

import java.util.Iterator;
import java.util.List;

/**
 * Created by matinaju on 6/19/17.
 */
public class FlattenIterator implements Iterator<Integer> {
    private int listIndex;
    private List<Iterator<Integer>> iteratorsList;

    public FlattenIterator(List<Iterator<Integer>> input) {
        listIndex = 0;
        iteratorsList = input;
    }

    @Override
    public boolean hasNext() {
        while (listIndex < iteratorsList.size() && !iteratorsList.get(listIndex).hasNext()) {
            listIndex++;
        }
        return listIndex < iteratorsList.size();
    }

    @Override
    public Integer next() {
        if (iteratorsList.get(listIndex).hasNext()) {
            return iteratorsList.get(listIndex).next();
        }
        return null;
    }
}
