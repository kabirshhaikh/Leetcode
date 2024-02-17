import java.util.PriorityQueue;

public class Main {
    public static void main (String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        int test = furthestBuilding(heights, bricks,ladders);
        System.out.println(test);

    }



    public static int furthestBuilding (int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderUsed = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int difference = heights[i + 1] - heights[i];
            if (difference > 0) {
                if (ladders > 0) {
                    ladderUsed.offer(difference);
                    ladders--;
                } else if (!ladderUsed.isEmpty() && difference > ladderUsed.peek()) {
                    bricks -= ladderUsed.poll();
                    ladderUsed.offer(difference);
                } else {
                    bricks -= difference;
                }
                if (bricks < 0) return i;
            }
        }

        return heights.length - 1;
    }
}