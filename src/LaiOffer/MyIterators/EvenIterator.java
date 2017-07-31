package LaiOffer.MyIterators;

import java.util.Iterator;

/**
 * Created by matinaju on 6/17/17.
 */
public class EvenIterator {
    Iterator<Integer> ite;
    Integer temp;

    public EvenIterator(Iterator<Integer> inputIte) {
        this.ite = inputIte;
        temp = null;
    }

    public boolean hasNext() {
        if (temp != null) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            if (!hasNext()) {
                return false;
            }
            temp = ite.next();
        }
        return false;
    }

    public int next() {
        Integer result;
        if (hasNext()) {
            result = temp;
            temp = null;
            return result;
        }
        throw new IndexOutOfBoundsException();
    }
}
