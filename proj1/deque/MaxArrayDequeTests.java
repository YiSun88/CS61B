package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTests {

    /** Support comparator class, max */
    private static class maxComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return (Integer) o1 - (Integer) o2;
        }
    }

    public static maxComparator getMaxComparator() {
        return new maxComparator();
    }

    private static class minComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return (Integer) o2 - (Integer) o1;
        }
    }

    public static minComparator getMinComparator() {
        return new minComparator();
    }

    private static class stringComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return ((String) o1).compareTo((String) o2);
        }
    }

    public static stringComparator getStringComparator() {
        return new stringComparator();
    }

    @Test
    public void testDefaultMax() {
        MaxArrayDeque<Integer> test = new MaxArrayDeque<>(getMaxComparator());
        int N = 10;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                int ranVal = StdRandom.uniform(0, 100);
                test.addFirst(ranVal);
                System.out.print(ranVal + " ");
            } else if (operationNumber == 1) {
                int ranVal = StdRandom.uniform(0, 100);
                test.addLast(ranVal);
                System.out.print(ranVal + " ");
            }
        }
        System.out.println();
        System.out.println(test.max());
        System.out.println(test.max(getMinComparator()));
    }

    @Test
    public void testStringMax() {
        MaxArrayDeque<String> test = new MaxArrayDeque<>(getMaxComparator());
        test.addFirst("aaa");
        test.addFirst("bbb");
        test.addFirst("bcc");
        System.out.println();
        System.out.println(test.max(getStringComparator()));
    }
}
