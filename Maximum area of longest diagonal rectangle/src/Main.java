public class Main {
    public static void main(String[] args) {
        int[][] dimensions = {{9, 3}, {8, 6}};
        int test = areaOfmMaxDiagonal(dimensions);
        System.out.println(test);
    }

    public static int areaOfmMaxDiagonal(int[][] dimensions) {
        int maxDiagonalSqr = -1;
        int maxArea = -1;

        for (int i = 0; i < dimensions.length; i++) {
            int[] current = dimensions[i];
            int length = current[0];
            int width = current[1];
            int diagonalSqr = (int) (length * length) + (width * width);
            int area = length * width;
            if (diagonalSqr > maxDiagonalSqr || diagonalSqr == maxDiagonalSqr && area > maxArea) {
                maxDiagonalSqr = diagonalSqr;
                maxArea = area;
            }
        }

        return maxArea;
    }
}
