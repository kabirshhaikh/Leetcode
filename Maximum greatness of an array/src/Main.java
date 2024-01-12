import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3,5,2,1,3,1};
        int test = maximizeGreatness(nums);
        System.out.println(test);
    }


    public static int maximizeGreatness (int[] nums) {
        PriorityQueue<Integer> pq1 = new PriorityQueue();
        PriorityQueue<Integer> pq2 = new PriorityQueue();
        for(int i: nums){
            pq1.add(i);
            pq2.add(i);
        }
        int count = 0;
        while(!pq2.isEmpty()){
            if(pq1.peek() < pq2.peek()){
                pq1.poll();
                count++;
            }
            pq2.poll();
        }
        return count;
    }
}