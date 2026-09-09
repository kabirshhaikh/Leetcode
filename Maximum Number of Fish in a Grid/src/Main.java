public class Main {
    public static void main (String[] args) {
        int[][] grid = {{0,2,1,0}, {4,0,0,3}, {1,0,0,4}, {0,3,2,0}};
        int output = findMaxFish(grid);
        System.out.println(output);
    }

    public static int findMaxFish(int[][] grid) {
        //here i capture rows and cols length:
        int rows = grid.length; int cols = grid[0].length;

        //so first i will define a boolean[][] array to track visited cells:
        boolean[][] visited =  new boolean[rows][cols];

        //now i defiena max variable to track output:
        int max = 0;

        //now i loop over grid:
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[row].length; col++) {
                //now if current cells value is greater than 0 and is not visited then i perform dfs:
                if (grid[row][col] > 0 && visited[row][col] == false) {
                    int result = dfs(row, col, visited, grid);
                    max = Math.max(max, result);
                }
            }
        }

        //in the end i return max:
        return max;
    }

    //now here i write my dfs recursion function of return type int:
    public static int dfs (int row, int col, boolean[][] visited, int[][] grid) {
        //first base case: if out of boundary then return 0:
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return 0;
        }

        //second base case: if cells value is 0 then return 0:
        if (grid[row][col] == 0) {
            return 0;
        }

        //thrid case: if current cell is > 0 and already visited:
        if (grid[row][col] > 0 && visited[row][col] == true) {
            return 0;
        }

        //otherwise capture current cells value:
        int current = grid[row][col];

        //now i mark current cell as visited:
        visited[row][col] = true;

        //perform dfs up, down left and right:
        int up = dfs(row - 1, col, visited, grid);

        int down = dfs(row + 1, col, visited, grid);

        int left = dfs(row, col - 1, visited, grid);

        int right = dfs(row, col + 1, visited, grid);

        //in the end i return current + up + down + left + right:
        return current + up + down + left + right;
    }
}


// land is 0
// water cell containing fish value > 0

// so the problem requires dfs.

// i will need a boolean array to track visited cells.

// then i will run a loop on grid and check if its > 0 then perform dfs.

// in dfs i will first do boundary check,
// then i will do if this cell is 0 then reutrn 0.

// if this cell is visited then return 0.

// other wise perform recursion and return current cells value + recursion dfs value.
