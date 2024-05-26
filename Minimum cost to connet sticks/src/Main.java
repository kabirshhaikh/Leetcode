import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main (String[] args) {
        int[] sticks = {2,4,3};
        int test = connectSticks(sticks);
        System.out.println(test);
    }


    public static int connectSticks (int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.offer(stick);
        }

        int totalCost = 0;

        // While there is more than one stick, combine the two smallest
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int combined = first + second;
            totalCost += combined;
            pq.offer(combined);
        }

        return totalCost;
    }


}
