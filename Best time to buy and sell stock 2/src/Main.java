public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        int test = maxProfit(prices);
        System.out.println(test);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(prices[i] - prices[i - 1], 0);
        }

        return maxProfit;
    }
}
