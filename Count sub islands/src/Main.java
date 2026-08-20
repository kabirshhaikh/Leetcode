public class Main {
    public static void main (String[] args) {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int output = countSubIslands(grid1, grid2);
        System.out.println(output);
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        //here i grab row and col length:
        int rows = grid2.length; int cols = grid2[0].length;

        //after that i create a 2d boolean visited array to track which cells are visited in grid2:
        boolean[][] visited = new boolean[rows][cols];

        //now i define out variable count to track sub islands:
        int count = 0;

        //now i loop over grid2:
        //whenever i encounter 1 and its not visited then i run dfs on it:
        for (int row=0; row<grid2.length; row++) {
            for (int col=0; col<grid2[row].length; col++) {
                //if not visited and current cell is 1 then i run dfs from that position:
                if (!visited[row][col] && grid2[row][col] == 1) {
                    //if dfs returns true i increment count counter:
                    if (dfs(visited, grid1, grid2, row, col)) {
                        count++;
                    }
                }
            }
        }

        //in the end i return count variable:
        return count;
    }

    //now here i write my dfs helper recursion method which has a return type of boolean:
    public static boolean dfs (boolean[][] visited, int[][] grid1, int[][] grid2, int row, int col) {
        //first base case: boundary check:
        if (row < 0 || row >= grid2.length || col < 0 || col >= grid2[row].length) {
            return true; //meaning nothing can be contributed from here:
        }

        //second base case: if current cell is 0 or already visited then return true nothing can be contributed from here:
        if (grid2[row][col] == 0 || visited[row][col]) {
            return true;
        }

        //now i mark the current cell as visited:
        visited[row][col] = true;

        //otherwise check current cells position in grid1, needs to be 1:
        boolean matches = (grid1[row][col] == 1);

        //now i perform recursion up down left and right:
        boolean up = dfs(visited, grid1, grid2, row - 1, col);

        boolean down = dfs(visited, grid1, grid2, row + 1, col);

        boolean left = dfs(visited, grid1, grid2, row, col - 1);

        boolean right = dfs(visited, grid1, grid2, row, col + 1);

        //in the end i return true when matches, up, down, left and right all are true else false:
        return matches && up && down && left && right;
    }
}


// so the problem demands dfs:
// the idea that i can think of is i need boolean visited 2d array to track which positions i have visited in grid2.
// then run for loop on grid 2, when a 1 is encountered i need to run dfs on it and check if that 1 and neighbours in that grid2 are 1 and they also need to be 1 in exact same position in grid 1.
// i run the dfs if current is 0 and not visited
// if the dfs return true then i increment a counter for output.


// dfs will have return type of boolean, it will get visited boolean 2d array, grid1 and grid and row and col to start recursion.
// first base case: boundary check, if out of boundary return true.
// second base case: if current cell is 0 or already visited then return true.
//then store result into a boolean variable matches so see if current cell is 1 in grid also.
// and recurse up down left and right.
//then in the end return true if all are true meaning matches, up, down, left and right.

