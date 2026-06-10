public class Main {
    public static void main(String[] args) {
        int[][] grid = {{7,1,4,5,6}, {2,5,1,6,4}, {1,5,4,3,2}, {1,2,7,3,4}};
        int test = largestMagicSquare(grid);
        System.out.println(test);
    }


    public static int largestMagicSquare(int[][] grid) {
        int[][] rowsPrefix = new int[grid.length][grid[0].length + 1];

        for (int i = 0; i < grid.length; i++) {
            int[] curr = grid[i];
            int[] insert = new int[curr.length + 1];
            insert[0] = 0;

            for (int j = 1; j <= curr.length; j++) {
                insert[j] = insert[j - 1] + curr[j - 1];
            }

            rowsPrefix[i] = insert;
        }

        int[][] colPrefix = new int[grid.length + 1][grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            colPrefix[0][i] = 0;
            for (int j = 0; j < grid.length; j++) {
                int curr = grid[j][i];
                colPrefix[j + 1][i] = colPrefix[j][i] + curr;
            }
        }

        int result = 1; // minimum is always 1

        // try every top-left corner (r, c)
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // try every possible size k
                for (int k = 2; k <= Math.min(grid.length - r, grid[0].length - c); k++) {
                    if (isMagic(r, c, k, grid, rowsPrefix, colPrefix)) {
                        result = Math.max(result, k);
                    }
                }
            }
        }
        return result;

    }

    private static boolean isMagic(int r, int c, int k, int[][] grid, int[][] rowsPrefix, int[][] colPrefix) {
        // get the target sum using first row
        int target = rowsPrefix[r][c + k] - rowsPrefix[r][c];

        // check all row sums
        for (int i = r; i < r + k; i++) {
            int rowSum = rowsPrefix[i][c + k] - rowsPrefix[i][c];
            if (rowSum != target)
                return false;
        }

        // check all column sums
        for (int j = c; j < c + k; j++) {
            int colSum = colPrefix[r + k][j] - colPrefix[r][j];
            if (colSum != target)
                return false;
        }

        // check diagonal top-left to bottom-right
        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != target)
            return false;

        // check diagonal top-right to bottom-left
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[r + i][c + k - 1 - i];
        }
        if (diag2 != target)
            return false;

        return true;
    }
}
