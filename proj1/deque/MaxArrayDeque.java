package deque;

import java.util.Comparator;

/** MaxArrayDeque extends ArrayDeque */
public class MaxArrayDeque<Type> extends ArrayDeque<Type> {
    Comparator<Type> defaultComparator;

    /** Create a MaxArrayDeque with the given comparator */
    public MaxArrayDeque(Comparator<Type> c) {
        super();
        defaultComparator = c;
    }

    /** Return the max element using default comparator */
    public Type max() {
        if (this.size() == 0) {
            return null;
        }
        int indexOfMax = 0;
        int i = 0;
        while (i < this.size()) {
            if (defaultComparator.compare(this.get(i), this.get(indexOfMax)) > 0) {
                indexOfMax = i;
            }
            i++;
        }
        return this.get(indexOfMax);
    }

    /** Return the max element using the passed in comparator */
    public Type max(Comparator<Type> newComparator) {
        if (this.size() == 0) {
            return null;
        }
        int indexOfMax = 0;
        int i = 0;
        while (i < this.size()) {
            if (newComparator.compare(this.get(i), this.get(indexOfMax)) > 0) {
                indexOfMax = i;
            }
            i++;
        }
        return this.get(indexOfMax);
    }
}
