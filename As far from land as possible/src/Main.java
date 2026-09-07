import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main (String[] args) {
        int[][] grid = {{1,0,1}, {0,0,0}, {1,0,1}};
        int output = maxDistance(grid);
        System.out.println(output);
    }

    public static int maxDistance(int[][] grid) {
        //here i fist define a boolean[][] array to track visited cell positions:
        int rows = grid.length; int cols = grid[0].length;

        //here i define maxDist variable:
        int maxDist = -1;

        //now here i define the boolean[][] array visited:
        boolean[][] visited = new boolean[rows][cols];

        //now here i define a queue which will hold 1 positions meaning land cells initially:
        Queue<int[]> q = new ArrayDeque<>();

        //now i will loop over grid and push all cells with 1 into q:
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //when a cell with 1 is encountered i will push it into queue and mark it visited:
                    q.offer(new int[] {i, j});

                    visited[i][j] = true;

                    grid[i][j] = 0; //i set it to 0 because a land cells distance to itself is 0 not the 1 set to it originally.
                }
            }
        }

        //now i will loop over queue until its not empty:
        while (!q.isEmpty()) {
            //now here i pop the cell:
            int[] poppedCell = q.poll();

            int poppedRow = poppedCell[0];
            int poppedColumn = poppedCell[1];

            //now i will check for edge cases to make sure the neighbouring cells meaning up, down, left and right are 0 and not out of boundary:
            //if its 0, not visited and inside boundary then i update its distance, mark it visited and push that position into q:

            //up:
            int upRow = poppedRow - 1;
            int upCol = poppedColumn;

            if (upRow >=0 && upRow < grid.length && upCol >= 0 && upCol < grid[upRow].length) {
                if (grid[upRow][upCol] == 0 && visited[upRow][upCol] == false) {
                    //so now I will update the distance for this cell:
                    grid[upRow][upCol] = grid[poppedRow][poppedColumn] + 1;

                    //then i mark this position as visited:
                    visited[upRow][upCol] = true;

                    //then i push this position into q:
                    q.offer(new int[] {upRow, upCol});

                    //now i update maxDist variable:
                    maxDist = Math.max(maxDist, grid[upRow][upCol]);
                }
            }


            //down:
            int downRow = poppedRow + 1;
            int downCol = poppedColumn;

            if (downRow >=0 && downRow < grid.length && downCol >= 0 && downCol < grid[downRow].length) {
                if (grid[downRow][downCol] == 0 && visited[downRow][downCol] == false) {
                    //so now I will update the distance for this cell:
                    grid[downRow][downCol] = grid[poppedRow][poppedColumn] + 1;

                    //then i mark this position as visited:
                    visited[downRow][downCol] = true;

                    //then i push this position into q:
                    q.offer(new int[] {downRow, downCol});

                    //now i update maxDist variable:
                    maxDist = Math.max(maxDist, grid[downRow][downCol]);
                }
            }

            //left:
            int leftRow = poppedRow;
            int leftCol = poppedColumn - 1;

            if (leftRow >=0 && leftRow < grid.length && leftCol >= 0 && leftCol < grid[leftRow].length) {
                if (grid[leftRow][leftCol] == 0 && visited[leftRow][leftCol] == false) {
                    //so now I will update the distance for this cell:
                    grid[leftRow][leftCol] = grid[poppedRow][poppedColumn] + 1;

                    //then i mark this position as visited:
                    visited[leftRow][leftCol] = true;

                    //then i push this position into q:
                    q.offer(new int[] {leftRow, leftCol});

                    //now i update maxDist variable:
                    maxDist = Math.max(maxDist, grid[leftRow][leftCol]);
                }
            }

            //right:
            int rightRow = poppedRow;
            int rightCol = poppedColumn + 1;

            if (rightRow >=0 && rightRow < grid.length && rightCol >= 0 && rightCol < grid[rightRow].length) {
                if (grid[rightRow][rightCol] == 0 && visited[rightRow][rightCol] == false) {
                    //so now I will update the distance for this cell:
                    grid[rightRow][rightCol] = grid[poppedRow][poppedColumn] + 1;

                    //then i mark this position as visited:
                    visited[rightRow][rightCol] = true;

                    //then i push this position into q:
                    q.offer(new int[] {rightRow, rightCol});

                    //now i update maxDist variable:
                    maxDist = Math.max(maxDist, grid[rightRow][rightCol]);
                }
            }
        }

        //in the end i return maxDist:
        return maxDist;
    }
}

// so the problem requires bfs.
// i will maintain a boolean[][] array to track which cells are visited.
// i will push all 1 cells into a queue.

// then i will run a while loop until q is not empty.
// i will pop the 1 cell.
// check if 4 sides has unvisited 0 cell.
// if yes then i will update distqance for that unvisited cell by currentPopped cells value + 1 and then push that position into queue.
