package implementations;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> data = new ArrayDeque<>();
        data.offer(2);
        data.offer(7);
        data.offer(6);
        data.offer(9);
        data.offer(4);

        for (Integer datum : data) {
            System.out.println(datum);
        }
    }

}