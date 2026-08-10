import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main (String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] output = updateMatrix(mat);
        for (int i=0; i<output.length; i++) {
            int[] curr = output[i];
            for (int j=0; j<curr.length; j++) {
                System.out.print(curr[j] + ", ");
            }
            System.out.println(" ");
        }
        System.out.println(output);
    }

    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length; int cols = mat[0].length;

        //this will hold output:
        int[][] output = new int[rows][cols];

        //here i define a queue:
        Queue<int[]> q = new ArrayDeque<>();

        //here i define a boolean[][] array to mark all 0 visited elements as true:
        boolean[][] visited = new boolean[rows][cols];

        //now here i run a for loop and add all the positions of 0 in the queue and mark those elements as true in the visited array:
        //also mark output's row and col as 0:
        for (int row=0; row<mat.length; row++) {
            for (int col=0; col<mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    q.offer(new int[] {row, col});
                    visited[row][col] = true;
                    output[row][col] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            //now i loop over starting from 0 until less than size:
            for (int i=0; i<size; i++) {
                int[] currPopped = q.poll();
                int row = currPopped[0];
                int col = currPopped[1];

                //now i check up:
                int upRow = row - 1; int upCol = col;
                if (upRow >= 0 && upRow < mat.length && upCol >= 0 && upCol < mat[upRow].length) {
                    if (!visited[upRow][upCol] && mat[upRow][upCol] == 1) {
                        //mark the visited row and col:
                        visited[upRow][upCol] = true;

                        //i pushed the current row and col into queue:
                        q.offer(new int[] {upRow, upCol});

                        //then i update output:
                        output[upRow][upCol] = output[row][col] + 1;
                    }
                }


                //now i check down:
                int downRow = row + 1; int downCol = col;
                if (downRow >= 0 && downRow < mat.length && downCol >= 0 && downCol < mat[downRow].length) {
                    if (!visited[downRow][downCol] && mat[downRow][downCol] == 1) {
                        //mark the visited row and col:
                        visited[downRow][downCol] = true;

                        //i pushed the current row and col into queue:
                        q.offer(new int[] {downRow, downCol});

                        //then i update output:
                        output[downRow][downCol] = output[row][col] + 1;
                    }
                }

                //now i check left:
                int leftRow = row; int leftCol = col - 1;
                if (leftRow >= 0 && leftRow < mat.length && leftCol >= 0 && leftCol < mat[leftRow].length) {
                    if (!visited[leftRow][leftCol] && mat[leftRow][leftCol] == 1) {
                        //mark the visited row and col:
                        visited[leftRow][leftCol] = true;

                        //i pushed the current row and col into queue:
                        q.offer(new int[] {leftRow, leftCol});

                        //then i update output:
                        output[leftRow][leftCol] = output[row][col] + 1;
                    }
                }

                //now i check right:
                int rightRow = row; int rightCol = col + 1;
                if (rightRow >= 0 && rightRow < mat.length && rightCol >= 0 && rightCol < mat[rightRow].length) {
                    if (!visited[rightRow][rightCol] && mat[rightRow][rightCol] == 1) {
                        //mark the visited row and col:
                        visited[rightRow][rightCol] = true;

                        //i pushed the current row and col into queue:
                        q.offer(new int[] {rightRow, rightCol});

                        //then i update output:
                        output[rightRow][rightCol] = output[row][col] + 1;
                    }
                }
            }
        }

        return output;
    }
}


//so this is how the algo will work.
//here I am going to use breadth first search approach.
//i am gonna create a queue, and run a for loop on mat and push all the 0 positions into the queue.
//i am also going to create a boolean[][] visited array where I will initially mark true for all 0 positions.

//then i run a while loop until queue is not empty:
//so inside the while loop i first check the size of the queue, and then i run a for loop on the size of the queue.
//after that in the for loop i pop the current position of 0 cell or 1 whos distance has been calculated already to visited other 1's whos not directly neighour of 0.
//then i check its up down left and right, if its 1 then i calculate its distance by adding 1 to whatever the current element value is, then add that 1's position into queue and mark is visited.
//in the end i return the output array
