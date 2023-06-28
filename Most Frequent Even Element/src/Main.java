import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {0,1,2,2,4,4,1};
        mostFrequent(nums);
    }

    public static int mostFrequent (int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber % 2 == 0) {
                myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
            }
        }

        int mostFrequentKey = -1;
        int mostFrequentCount = 0;
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            int key = map.getKey();
            if (value > mostFrequentCount || (value == mostFrequentCount && key < mostFrequentKey )) {
                mostFrequentCount = value;
                mostFrequentKey = key;
            }
        }
        return mostFrequentKey;
    }

}