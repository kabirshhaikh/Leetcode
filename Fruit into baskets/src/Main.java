import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        int test = totalFruit(fruits);
        System.out.println(test);
    }


    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            int current = fruits[right];
            myMap.put(current, myMap.getOrDefault(current, 0) + 1);

            while (myMap.size() > 2) {
                int atLeft = fruits[left];
                int countOfNumberAtLeft = myMap.get(atLeft);
                if (countOfNumberAtLeft == 1) {
                    myMap.remove(atLeft);
                } else {
                    myMap.put(atLeft, countOfNumberAtLeft - 1);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
