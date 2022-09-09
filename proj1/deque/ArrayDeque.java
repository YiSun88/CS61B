package deque;

import java.util.Iterator;

public class ArrayDeque<Type> implements Deque<Type>, Iterable<Type> {
    private Type[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Constructor for the ArrayDeque */
    public ArrayDeque() {
        items = (Type []) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /** Helper function to ensure the index number is always inside the boundary of the Array List */
    private int trueIndex(int i) {
        return (i + items.length) % items.length;
    }

    /** Helper function to resize the array */
    private Type[] resize(int capacity) {
        Type[] resizedArray = (Type []) new Object[capacity];
        return resizedArray;
    }

    /** Iterator Class*/
    private class arrayIterator implements Iterator<Type> {
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            if (this.currentIndex < size) {
                return true;
            }
            return false;
        }

        @Override
        public Type next() {
            Type returnedItem = items[trueIndex(nextFirst + currentIndex + 1)];
            currentIndex++;
            return returnedItem;
        }
    }

    /** Override the iterator creator */
    @Override
    public Iterator<Type> iterator() {
        return new arrayIterator();
    }

    /** Override Object.equals method*/
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque list = (Deque) o;
        if (this.size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            boolean sameItemI = this.get(i).equals(list.get(i));
            if (!sameItemI) {
                return false;
            }
        }
        return true;
    }

    /** Add an item to front of the Array List */
    public void addFirst(Type x) {
        if (size == items.length) {
            Type[] resizedArray = resize(size * 2);
            int trueFirstIndex = trueIndex(nextFirst + 1);
            System.arraycopy(items, trueFirstIndex, resizedArray, 0, size - trueFirstIndex);
            System.arraycopy(items, 0, resizedArray, size - trueFirstIndex, trueFirstIndex);
            items = resizedArray;
            nextFirst = resizedArray.length - 1;
            nextLast = size;
        }
        items[nextFirst] = x;
        nextFirst = trueIndex(nextFirst - 1);
        size++;
    }

    /** Add an item to end of the Array List */
    public void addLast(Type x) {
        if (size == items.length) {
            Type[] resizedArray = resize(size * 2);
            int trueFirstIndex = trueIndex(nextFirst + 1);
            System.arraycopy(items, trueFirstIndex, resizedArray, 0, size - trueFirstIndex);
            System.arraycopy(items, 0, resizedArray, size - trueFirstIndex, trueFirstIndex);
            items = resizedArray;
            nextFirst = resizedArray.length - 1;
            nextLast = size;
        }
        items[nextLast] = x;
        nextLast = trueIndex(nextLast + 1);
        size++;
    }

    /** Get size of the Array List */
    public int size() {
        return size;
    }

    /** Check if the Array List is empty */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Print items in the Array List */
    public void printDeque() {
        for (int i = 1; i <= size; i++) {
            System.out.print(items[trueIndex(nextFirst + i)] + " ");
        }
        System.out.println();
    }

    /** Remove first item in the Array List */
    public Type removeFirst() {
        if (size == 0) {
            return null;
        }
        if ((double) (size - 1) / items.length < 0.25 && size > 16) {
            Type[] resizedArray = resize(items.length / 2);
            int trueFirstIndex = trueIndex(nextFirst + 1);
            if (trueFirstIndex + size > items.length) {
                System.arraycopy(items, trueFirstIndex, resizedArray, 0, items.length - trueFirstIndex);
                System.arraycopy(items, 0, resizedArray, items.length - trueFirstIndex, size - items.length + trueFirstIndex);
            } else {
                System.arraycopy(items, trueFirstIndex, resizedArray, 0, size);
            }
            items = resizedArray;
            nextFirst = resizedArray.length - 1;
            nextLast = size;
        }
        int trueFirst = trueIndex(nextFirst + 1);
        Type removed = items[trueFirst];
        nextFirst = trueFirst;
        size--;
        return removed;
    }

    /** Remove last item in the Array List */
    public Type removeLast() {
        if (size == 0) {
            return null;
        }
        if ((double) (size - 1) / items.length < 0.25 && size > 16) {
            Type[] resizedArray = resize(items.length / 2);
            int trueFirstIndex = trueIndex(nextFirst + 1);
            if (trueFirstIndex + size > items.length) {
                System.arraycopy(items, trueFirstIndex, resizedArray, 0, items.length - trueFirstIndex);
                System.arraycopy(items, 0, resizedArray, items.length - trueFirstIndex, size - items.length + trueFirstIndex);
            } else {
                System.arraycopy(items, trueFirstIndex, resizedArray, 0, size);
            }
            items = resizedArray;
            nextFirst = resizedArray.length - 1;
            nextLast = size;
        }
        int trueLast = trueIndex(nextLast - 1);
        Type removed = items[trueLast];
        nextLast = trueLast;
        size--;
        return removed;
    }

    /** Get the item at index index */
    public Type get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        int actualIndex = trueIndex(nextFirst + 1 + index);
        return items[actualIndex];
    }
}
