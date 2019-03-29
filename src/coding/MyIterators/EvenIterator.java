package coding.MyIterators;

import java.util.Iterator;
import java.util.List;

/**
 * Created by matinaju on 6/17/17.
 */
public class EvenIterator {
    List<Integer> list;
    Iterator<Integer> ite;
    Integer temp;

    public EvenIterator(List<Integer> input) {
        this.list = input;
        this.ite = input.iterator();
        temp = null;
    }

    public boolean hasNext() {
        if (temp != null) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            if (ite.hasNext()) {
                temp = ite.next();
            } else {
                return false;
            }
        }
        return true;
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
