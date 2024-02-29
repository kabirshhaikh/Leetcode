public class Main {
    public static void main (String[] args) {
        int[][] grid = {{5,7,0}, {0,3,1}, {0,5,0}};
        boolean test = checkXMatrix(grid);
        System.out.println(test);
    }


    public static boolean checkXMatrix (int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 0 || grid[i][n - i - 1] == 0) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && j != n - i - 1 && grid[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}