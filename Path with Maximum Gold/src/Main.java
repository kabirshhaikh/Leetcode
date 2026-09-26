public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };

        int output = getMaximumGold(grid);

        System.out.println(output);
    }

    public static int getMaximumGold(int[][] grid) {
        //so first i define the output variable:
        int output = 0;

        //so here i write an outer loop from which i will perform backtracking:
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                //if current cell is not zero then perform backtracking:
                if (grid[row][col] != 0) {
                    int backTrackResult = dfs(grid, row, col);
                    output = Math.max(output, backTrackResult);
                }
            }
        }

        //return output:
        return output;
    }

    //now here i write the dfs recursion helper method:
    public static int dfs(int[][] grid, int row, int col) {
        //first base case: make sure not out of bounds:
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return 0;
        }

        //second base case: if current cell is 0 then return:
        if (grid[row][col] == 0) {
            return 0;
        }

        //otherwise capture current cells val:
        int capturedValue = grid[row][col];

        //mark current cell as 0:
        grid[row][col] = 0;

        //explore four directions:
        int left = dfs(grid, row, col - 1);
        int right = dfs(grid, row, col + 1);
        int top = dfs(grid, row - 1, col);
        int down = dfs(grid, row + 1, col);

        //after exploring four directions restore current cells value:
        grid[row][col] = capturedValue;

        int maxFromFour = Math.max(Math.max(left, right), Math.max(top, down));

        //in the end return current cells value + maxFromFour:
        return capturedValue + maxFromFour;
    }
}

//so this questions is of type backtracking.
//i will use dfs.
//break case is first, make sure not out of bounds, return.
//second if its 0 then return.
//then capture current cells value.
//mark current cell as 0.
//then define top, right, left and down and perform recursion in those direction
//then after exploring around, restore current cells value with captured val.
//then return current cell + max from 4 directions.
