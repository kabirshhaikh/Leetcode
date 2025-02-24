import java.util.Arrays;

public class Main {
    public static void main (String[] whatUpMan) {
        int[][] grid = {{-15,1,3}, {15,7,12}, {5,6,-2}};
        int [] test = findColumnWidth(grid);
        System.out.println(Arrays.toString(test));
    }

    //-15 1 3
    // 15 7 12
    // 5,6, -2

    private static int[] findColumnWidth (int[][] grid) {
        int[] output = new int[grid[0].length];
        int row = grid.length;
        int col = grid[0].length;

        for (int j=0; j<col; j++) {
            int largest = -1;
            for (int i=0; i<row; i++) {
                String currentElement = String.valueOf(grid[i][j]);
                if (currentElement.length() > largest) {
                    largest = currentElement.length();
                }
            }
            output[j] = largest;
        }

        return output;
    }
}
