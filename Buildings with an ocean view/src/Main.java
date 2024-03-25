import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main (String[] args) {
        int[] heights = {4,2,3,1};
        int[] test = findBuildings(heights);
        System.out.println(Arrays.toString(test));
    }


    public static int[] findBuildings (int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[stack.peek()] < heights[i]) {
                stack.push(i);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }

        return res;
    }
}