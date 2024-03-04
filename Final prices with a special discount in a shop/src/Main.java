import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        int[] test = finalPrices(prices);
        System.out.println(Arrays.toString(test));
    }


    public static int[] finalPrices (int[] prices) {
        int[] output = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            output[i] = prices[i] - discount;
        }

        return output;
    }
}