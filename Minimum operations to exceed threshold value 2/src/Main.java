import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {
        int k = 20;
        int[] nums = {1,1,2,4,9};
        int test = minOperations(nums, k);
        System.out.println(test);
    }



    private static int minOperations (int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>(
                Arrays.stream(nums)
                        .mapToLong(i -> (long) i)
                        .boxed()
                        .collect(Collectors.toList())
        );
        int numOperations = 0;

        while (minHeap.peek() < k) {
            long x = minHeap.remove();
            long y = minHeap.remove();
            minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));

            numOperations++;
        }
        return numOperations;
    }

}
