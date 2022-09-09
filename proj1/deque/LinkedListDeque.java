package deque;

import java.util.Iterator;

public class LinkedListDeque<Type> implements Deque<Type>, Iterable<Type>{

    /** Nested class for each node in the linked list*/
    private class Node {
        private Node previous;
        private Type item;
        private Node next;

        /** Construct a new Node*/
        private Node(Type x, Node nPrevious, Node nNext) {
            item = x;
            previous = nPrevious;
            next = nNext;
        }
    }

    /** Helper class iterator*/
    private class LinkedListIterator implements Iterator<Type> {
        private Node iteratorP = sentinel;

        @Override
        public boolean hasNext() {
            if (iteratorP.next != sentinel) {
                return true;
            }
            return false;
        }

        @Override
        public Type next() {
            Type returned = iteratorP.next.item;
            iteratorP = iteratorP.next;
            return returned;
        }
    }

    /** Constructor for iterator LinkedListIterator*/
    @Override
    public Iterator<Type> iterator() {
        return new LinkedListIterator();
    }

    /** Method for equals */
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

    /** Instance variables for Linked List*/
    private Node sentinel;
    private int size;

    /** Construct an empty linked list*/
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
    }

    /** Add an item to the first position of the linked list*/
    @Override
    public void addFirst(Type x) {
        Node added = new Node(x, sentinel, sentinel.next);
        sentinel.next.previous = added;
        sentinel.next = added;
        size++;
    }

    /** Add an item to the last position of the linked list*/
    @Override
    public void addLast(Type x) {
        Node added = new Node(x, sentinel.previous, sentinel);
        sentinel.previous.next = added;
        sentinel.previous = added;
        size++;
    }

    /** Get the size of linked list*/
    @Override
    public int size() {
        return size;
    }

    /** Check if the linked list is empty*/
//    @Override
//    public boolean isEmpty() {
//        if (size == 0) {
//            return true;
//        }
//        return false;
//    }

    /** Print the items in the linked list*/
    @Override
    public void printDeque() {
        if (size == 0) {
            return;
        }
        Node current = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    /** Remove the first item */
    @Override
    public Type removeFirst() {
        if (size == 0) {
            return null;
        }
        Type removed = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        size--;
        return removed;
    }

    /** Remove the last item */
    @Override
    public Type removeLast() {
        if (size == 0) {
            return null;
        }
        Type removed = sentinel.previous.item;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        size--;
        return removed;
    }

    /** Get the item at index */
    @Override
    public Type get(int index) {
        if (index > size - 1) {
            return null;
        }
        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    /** Get the item at index, using recursion */
    public Type getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getRecursiveHelp(index, sentinel.next);
    }

    /** Helper function for getRecursive */
    private Type getRecursiveHelp(int index, Node currNode) {
        if (index == 0) {
            return currNode.item;
        }
        return getRecursiveHelp(index - 1, currNode.next);
    }
}
