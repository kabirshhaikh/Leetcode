public class Main {
    public static void main (String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        int test = diagonalSum(mat);
        System.out.println(test);
    }


    public static int diagonalSum (int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] currentRow = mat[i];
            sum += currentRow[i]; // Primary diagonal
            if (i != n - 1 - i) { // Exclude the middle element
                sum += currentRow[n - 1 - i]; // Secondary diagonal
            }
        }

        return sum;
    }
}
