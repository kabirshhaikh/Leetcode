import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] heights = {1,1,4,2,1,3};
        heightChecker(heights);
    }
    public static int heightChecker (int[] heights) {
        int[] expected = new int[heights.length];
        int count = 0;
        for (int i=0; i<heights.length; i++) {
            expected[i] = heights[i];
        }
        Arrays.sort(expected);
        for (int i=0; i<heights.length; i++) {
            if (heights[i] != expected[i]) {
                count = count + 1;
            }
        }
        System.out.println("Count:" +count);
        return count;
    }

}