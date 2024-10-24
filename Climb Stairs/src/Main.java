public class Main {
    public static void main (String[] args) {
        int n = 3;
        int test = climbStairs(n);
        System.out.println(test);
    }


    public static int climbStairs (int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=n; i++) {
            dp[i] = climbStairs(n-1) + climbStairs(n-2);
        }

        return dp[n];
    }
}
