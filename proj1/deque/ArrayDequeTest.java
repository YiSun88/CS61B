package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    @Test
    public void addFirstAddLastTest() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        test1.addFirst(1);
        test1.addLast(2);
        assertEquals(2, test1.size());
    }

    @Test
    public void isEmptyTest() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        assertTrue(test1.isEmpty());
    }

    @Test
    public void printTest() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        test1.addFirst(1);
        test1.addLast(2);
        test1.printDeque();
    }

    @Test
    public void removeFirstTest() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        test1.addFirst(2);
        test1.addFirst(1);
        test1.addLast(3);
        int removed = test1.removeFirst();
        assertEquals(2, test1.size());
        assertEquals(1, removed);
    }

    @Test
    public void removeLastTest() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        test1.addFirst(2);
        test1.addFirst(1);
        test1.addLast(3);
        int removed = test1.removeLast();
        assertEquals(2, test1.size());
        assertEquals(3, removed);
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        int N = 5;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                int ranVal = StdRandom.uniform(0, 100);
                test1.addFirst(ranVal);
            } else if (operationNumber == 1) {
                int ranVal = StdRandom.uniform(0, 100);
                test1.addLast(ranVal);
            }
        }
        for (int i = 0; i < N; i++) {
            int returned1 = test1.get(i);
            System.out.println(returned1);
        }
    }

    @Test
    public void testLongAddFirst() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        int N = 500;
        for (int i = 0; i < N; i++) {
            test1.addFirst(i);
            assertEquals(i + 1, test1.size());
            assertEquals(i, (int) test1.get(0));
        }
    }

    @Test
    public void testLongAddLast() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        int N = 500;
        for (int i = 0; i < N; i++) {
            test1.addLast(i);
            int size = test1.size();
            assertEquals(i + 1, size);
            assertEquals(i, (int) test1.get(size - 1));
        }
    }

    @Test
    public void testLongRemoveFirst() {
        ArrayDeque<Integer> test1 = new ArrayDeque<>();
        int N = 4000;
        for (int i = 0; i < N; i++) {
            test1.addFirst(i);
        }
        for (int i = 0; i < N; i++) {
            int removed = test1.removeFirst();
            assertEquals(N - 1 - i, test1.size());
            assertEquals(N - 1 - i, removed);
        }
    }

    @Test
    public void largeScaleRandomizedTest() {
        LinkedListDeque<Integer> test1 = new LinkedListDeque<>();
        ArrayDeque<Integer> test2 = new ArrayDeque<>();

        int N = 500000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // Test addFirst
                int randVal = StdRandom.uniform(0, 100);
                test1.addFirst(randVal);
                test2.addFirst(randVal);
            } else if (operationNumber == 1) {
                // Test addLast
                int randVal = StdRandom.uniform(0, 100);
                test1.addLast(randVal);
                test2.addLast(randVal);
            } else if (operationNumber == 2 && test1.size() > 0) {
                // Test removeFirst
                int removed1 = test1.removeFirst();
                int removed2 = test2.removeFirst();
                assertEquals(removed1, removed2);
            } else if (operationNumber == 3 && test1.size() > 0) {
                // Test removeLast
                int removed1 = test1.removeLast();
                int removed2 = test2.removeLast();
                assertEquals(removed1, removed2);
            } else if (operationNumber == 4) {
                // Test size()
                int size1 = test1.size();
                int size2 = test2.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 5 && test1.size() > 0) {
                // Test get
                int randVal = StdRandom.uniform(0, test1.size());
                int item1 = test1.get(randVal);
                int item2 = test2.get(randVal);
                assertEquals(item1, item2);
            }
        }
    }
}
