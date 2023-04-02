import java.util.ArrayList;

public class Main {
    public static void main (String[] test) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        maxProfit(prices);

    }

    public static int maxProfit (int[] prices) {
        int maxProfit = 0;
        int lowestPrice = Integer.MAX_VALUE;
        int highestPrice = 0;
        for (int i=0; i<prices.length; i++) {
            int currentPrice = prices[i];
            if (currentPrice < lowestPrice) {
                lowestPrice = currentPrice;
                highestPrice = 0;
            } else if (currentPrice > highestPrice) {
                highestPrice = currentPrice;
                maxProfit = Math.max(maxProfit, highestPrice - lowestPrice);
            }
        }
        System.out.println(maxProfit);
        return maxProfit;
    }

}