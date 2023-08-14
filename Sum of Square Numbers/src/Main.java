public class Main {
    public static void main (String[] args) {
        int c = 2147483600;
        boolean test = judgeSquareSum(c);
        System.out.println(test);
    }

    public static boolean judgeSquareSum (int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            long currentSum = (long) left*left + (long) right*right;
            if (currentSum == c) {
                return true;
            }
            else if (currentSum < c) {
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }

}
