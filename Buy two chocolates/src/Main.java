import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        int[] prices = {3,2,3};
        int money = 3;
        int test = buyChoco(prices, money);
        System.out.println(test);
    }


    public static int buyChoco (int[] prices, int money) {
        int minCost = Integer.MAX_VALUE;

        int n = prices.length;

        for (int firstChoco = 0; firstChoco < n; firstChoco++) {
            for (int secondChoco = firstChoco + 1; secondChoco < n; secondChoco++) {
                // Sum of Prices of the Two Chocolates
                int cost = prices[firstChoco] + prices[secondChoco];


                if (cost < minCost) {
                    minCost = cost;
                }
            }
        }

        if (minCost <= money) {
            return money - minCost;
        } else {
            return money;
        }
    }
}