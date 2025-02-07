import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int limit = 4;
        int[][] queries = {{0,1}, {1,2}, {2,2}, {3,4}, {4,5}, {1,3}};
        int[] test = queryResults(limit, queries);
        System.out.println(Arrays.toString(test));
    }

    private static int[] queryResults (int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        HashMap<Integer, Integer> ballMap = new HashMap<>();

        // Iterate through queries
        for (int i = 0; i < n; i++) {
            // Extract ball label and color from query
            int ball = queries[i][0];
            int color = queries[i][1];

            // Check if ball is already colored
            if (ballMap.containsKey(ball)) {
                // Decrement count of the previous color on the ball
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);

                // If there are no balls with previous color left, remove color from color map
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }
            // Set color of ball to the new color
            ballMap.put(ball, color);

            // Increment the count of the new color
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            result[i] = colorMap.size();
        }
        return result;
    }
}




