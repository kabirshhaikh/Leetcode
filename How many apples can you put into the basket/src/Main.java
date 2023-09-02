import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] weight = {900,950,800,1000,700,800};
        int test = maxNumberOfApples(weight);
        System.out.println(test);
    }

    public static int maxNumberOfApples (int[] weight) {
        Arrays.sort(weight);
        int maxWeight = 5000;
        int currentWeight = 0;
        int count = 0;
        for (int i=0; i<weight.length; i++ ) {
            int currentNumber = weight[i];
            currentWeight = currentWeight + currentNumber;
            if (currentWeight <= maxWeight) {
                count = count + 1;
            }
        }
        return count;
    }
}