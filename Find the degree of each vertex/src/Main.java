import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        int[] output = findDegrees(matrix);
        System.out.println(Arrays.toString(output));
    }

    public static int[] findDegrees(int[][] matrix) {
        int[] output = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int[] curr = matrix[i];
            int count = 0;
            for (int j = 0; j < curr.length; j++) {
                if (curr[j] == 1) {
                    count++;
                }
            }

            output[i] = count;
        }

        return output;
    }


// 0th row:
// [0,1,1]:
// 0 is connected to 0 -> NO
// 0 is connected to 1 -> YES
// 0 is connected to 2 -> YES

// 1st row:
// [1,0,1]
// 1 is connected to 0 -> YES
// 1 is connected to 1 -> NO
// 1 is conencted to 2 -> YES

// 2nd row:
// [1,1,0]
// 2 is connected to 0 -> YES
// 2 is connected to 1 -> YES
// 2 is connected to 2 -> NO
}
