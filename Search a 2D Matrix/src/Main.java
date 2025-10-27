public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 103;
        boolean test = searchMatrix(matrix, target);
        System.out.println(test);
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean output = false;

        for (int i = 0; i < matrix.length; i++) {
            int[] current = matrix[i];

            int left = 0;
            int right = current.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (target == current[mid]) {
                    return true;
                } else if (target < current[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return output;
    }
}
