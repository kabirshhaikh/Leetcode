import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(matrix);
    }


    private static void setZeroes (int[][] matrix) {
        boolean[] rowsWithZero = new boolean[matrix.length];
        boolean[] columnsWithZero = new boolean[matrix[0].length];

        //Mark zeroes:
        for (int i=0; i<matrix.length; i++) {
            int[] currentRow = matrix[i];
            for (int j=0; j<currentRow.length; j++) {
                if (currentRow[j] == 0) {
                    rowsWithZero[i] = true;
                    columnsWithZero[j] = true;
                }
            }
        }

        //Convert marked rows to zero:
        for (int i=0; i< matrix.length; i++) {
            if (rowsWithZero[i] == true) {
                Arrays.fill(matrix[i], 0);
            }
        }


        //Convert marked coloumns to zero:
        for (int i=0; i<matrix[0].length; i++) {
            if (columnsWithZero[i] == true) {
                for (int j=0; j<matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // Step 4: Print the updated matrix
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
