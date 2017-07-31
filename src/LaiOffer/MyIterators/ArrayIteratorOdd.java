package LaiOffer.MyIterators;

import java.util.Iterator;

/**
 * Created by matinaju on 6/17/17.
 */
public class ArrayIteratorOdd implements Iterator<Integer> {
    int currentIndex;
    int oddIndex;
    int[] array;

    public ArrayIteratorOdd(int[] array) {
        currentIndex = 0;
        oddIndex = -1;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < array.length && array[currentIndex] % 2 == 0) {
            currentIndex++;
        }
        if (currentIndex == array.length) {
            return false;
        } else {
            oddIndex = currentIndex;
            return true;
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            currentIndex++;
            return array[oddIndex];
        } else {
            return null;
        }
    }
}
