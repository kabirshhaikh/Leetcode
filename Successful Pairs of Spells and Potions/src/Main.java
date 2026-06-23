import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        int success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] output = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int curr = spells[i];
            int low = 0;
            int high = potions.length;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if ((long) potions[mid] * curr >= success) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            output[i] = potions.length - low;
        }

        return output;
    }
}
