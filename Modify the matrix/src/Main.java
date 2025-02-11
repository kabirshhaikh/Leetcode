import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int[][] matrix = {{1,2,-1}, {4,-1,6}, {7,8,9}};
        int[][] test = modifiedMatrix(matrix);
        System.out.println(Arrays.deepToString(test));
    }

    private static int[][] modifiedMatrix (int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int[][] answer = new int[matrix.length][matrix[0].length];
        HashMap<Integer, Integer> map = new HashMap<>();

        //Iterate over columns and check the largest element in that column and store it in hashmap:
        for (int col=0; col<matrix[0].length; col++) {
            int largestInCol = -1;
            for (int row=0; row<matrix.length; row++) {
                if (matrix[row][col] > largestInCol) {
                    largestInCol = matrix[row][col];
                }
            }
            map.put(col, largestInCol);
        }

        //Make copy of matrix and store in answer by replace -1 with value of corresponding col in hashmap:
        for (int row=0; row<matrix.length; row++) {
            int[] current = matrix[row];
            for (int col=0; col<current.length; col++) {
                if (matrix[row][col] ==  -1) {
                    answer[row][col] = map.get(col);
                }
                else {
                    answer[row][col] = current[col];
                }
            }
        }

        //return answer array:
        return answer;
    }
}
