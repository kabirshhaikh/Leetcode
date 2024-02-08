import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[][] matrix = {{3,7,8}, {9,11,13}, {15,16,17}};
        luckyNumbers(matrix);
    }


    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbersList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int smallestNumberInRow = Integer.MAX_VALUE;
            int columnIndexOfSmallestNumber = -1;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < smallestNumberInRow) {
                    smallestNumberInRow = matrix[i][j];
                    columnIndexOfSmallestNumber = j;
                }
            }

            boolean isLucky = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][columnIndexOfSmallestNumber] > smallestNumberInRow) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                luckyNumbersList.add(smallestNumberInRow);
            }
        }

        return luckyNumbersList;
    }
}
