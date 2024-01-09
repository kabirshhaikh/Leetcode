public class Main {
    public static void main (String[] args) {
        int[] nums = {4,7,9,3,9};
        int[] divisors = {5,2,3};
        int test = maxDivScore(nums, divisors);
        System.out.println(test);
    }

    public static int maxDivScore (int[] nums, int[] divisors) {
        int maxScore = -1;
        int maxDivisor = Integer.MAX_VALUE;

        for (int divisor : divisors) {
            int score = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }
            if (score > maxScore || (score == maxScore && divisor < maxDivisor)) {
                maxScore = score;
                maxDivisor = divisor;
            }
        }

        return maxDivisor;
    }
}