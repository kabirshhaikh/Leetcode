public class Main {
    public static void main (String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int output = closedIsland(grid);
        System.out.println(output);
    }

    public static int closedIsland(int[][] grid) {
        //here i capture rows and cols length:
        int rows = grid.length;
        int cols = grid[0].length;

        //then i define a 2d array initially false of size m rows and n cols:
        boolean[][] visited = new boolean[rows][cols];

        //now i define a variable to count closedIslands:
        int closedIslands = 0;

        //now i run a nested loop over grid and start dfs when i encounter a cell with val 0:
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                //is the current cell is 0 and not visited:
                if (grid[row][col] == 0 && !visited[row][col]) {
                    if (!dfs(row, col, visited, grid)) {
                        //here i increment closedIslands if dfs returns false, meaning the cells dont touch the boundary and forms a closedIsland:
                        closedIslands++;
                    }
                }
            }
        }

        //in the end i return closedIslands:
        return closedIslands;
    }

    //this is my helper dfs recursion function of return type boolean:
    public static boolean dfs(int row, int col, boolean[][] visited, int[][] grid) {
        //first base case: to check if current cell is not array out of bounds:
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return true;
        }

        //second base case: if a cell is water meaning 1 or is visited then return false:
        if (grid[row][col] == 1 || visited[row][col] == true) {
            return false;
        }

        //otherwise mark current position as visited:
        visited[row][col] = true;

        //here i store the answer for: is this cell sitting on 1st or last row or 1st or last col:
        boolean currentStatus = (row == 0 || row == grid.length - 1 || col == 0 || col == grid[row].length - 1);

        //then i do recursion up down left and right:
        boolean up = dfs(row - 1, col, visited, grid);

        boolean down = dfs(row + 1, col, visited, grid);

        boolean left = dfs(row, col - 1, visited, grid);

        boolean right = dfs(row, col + 1, visited, grid);

        return currentStatus || up || down || left || right;
    }
}


// 1,1,1,1,1,1,1,0
// 1,0,0,0,0,1,1,0
// 1,0,1,0,1,1,1,0
// 1,0,0,0,0,1,0,1
// 1,1,1,1,1,1,1,0

// positions: 11, 12, 13, 14, 21, 31, 32, 33, 34 forms 1 island.
// position: 36 forms another island
// total closed island: 2

//the problem demands dfs:
//so i create a 2d boolean array initially all false to track visited and unvisited cells.
//i then define a closedIsland counter to track the output.
//i run a nested for loop on grid and when i encounter a 0 i start dfs on it.
//the dfs will return true or false, if false i increment closedIsland counter otherwise i continue the loop.

//the dfs helper function:
//first base case: boundary check, return true.
//second base case: if the cell is 0 and visited then return false.
//otherwise i mark the cell as visited.
//then i check if the cell is sitting at row 0 or col 0 or last row or last rows last col -> store that in boolean variable.
//then i recurse up down left and right.
//then i return true if either current status OR up OR down OR left OR right is true else false.

//then coming back to for loop, after it finishes i return the closedIsland variable.
