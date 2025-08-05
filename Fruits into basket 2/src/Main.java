import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] fruits = {3,6,1};
        int[] baskets = {6,4,7};
        int test = numOfUnplacedFruits(fruits, baskets);
        System.out.println(test);
    }


    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = 0;
        boolean[] used = new boolean[baskets.length];

        for (int i = 0; i < fruits.length; i++) {
            int currentFruit = fruits[i];
            boolean placed = false;

            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && baskets[j] >= currentFruit) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                unplaced++;
            }
        }

        return unplaced;
    }
}
