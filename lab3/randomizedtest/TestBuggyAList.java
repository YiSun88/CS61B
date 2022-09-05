package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> noResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        for (int i = 4; i < 7; i++) {
            noResizing.addLast(i);
            buggyAList.addLast(i);
        }
        while (noResizing.size() > 0) {
            assertEquals(noResizing.removeLast(), buggyAList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bugList = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bugList.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeBug = bugList.size();
//                System.out.println("size: " + size);
                assertEquals(size, sizeBug);
            } else if (L.size() > 0 && operationNumber == 2) {
                int last = L.getLast();
                int lastBug = bugList.getLast();
//                System.out.println("Last item: " + last);
                assertEquals(last, lastBug);
            } else if (L.size() > 0 && operationNumber == 3) {
                int lastRemoved = L.removeLast();
                int lastRemovedBug = bugList.removeLast();
                assertEquals(lastRemoved, lastRemovedBug);
//                System.out.println("Removed last: " + lastRemoved);
            }
        }
    }
}
