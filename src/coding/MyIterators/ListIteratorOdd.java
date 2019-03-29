package LaiOffer.MyIterators;

import java.util.Iterator;

/**
 * Created by matinaju on 6/17/17.
 */
public class ListIteratorOdd implements Iterator<Integer> {
    Iterator<Integer> ite;
    Integer temp;

    public ListIteratorOdd(Iterator<Integer> inputIte) {
        this.ite = inputIte;
        temp = null;
    }

    /**
     * the first condition is to avoid skipping some odd number.
     *
     * @return true if there exists next odd number.
     */
    @Override
    public boolean hasNext() {
        if (temp != null) {
            return true;
        }
        while (ite.hasNext()) {
            int t = ite.next();
            if (t % 2 == 1) {
                temp = t;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        Integer result;
        if (hasNext()) {
            result = temp;
            temp = null;
            return result;
        }
        return null;
    }
}
