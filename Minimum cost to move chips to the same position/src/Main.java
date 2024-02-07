import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] position = {1,2,3};
        int test = minCostToMoveChips(position);
        System.out.println(test);
    }


    public static int minCostToMoveChips (int[] position) {
        int evenCount = 0;
        int oddCount = 0;

        for (int chipPosition : position) {
            if (chipPosition % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(evenCount, oddCount);
    }
}