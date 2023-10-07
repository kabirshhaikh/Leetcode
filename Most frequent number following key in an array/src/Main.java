import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] agrs) {
        int[] nums = {1,1};
        int key = 1;
        int test = mostFrequent(nums, key);
        System.out.println(test);
    }


    public static int mostFrequent (int[] nums, int key) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<nums.length-1; i++) {
            int currentNumber = nums[i];
            if (currentNumber == key) {
                int nextNumber = nums[i+1];
                myMap.put(nextNumber, myMap.getOrDefault(nextNumber, 0) + 1);
            }
        }
        int countOfOccurrence = Integer.MIN_VALUE;
        int output = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int ke = map.getKey();
            int count = map.getValue();
            if (count > countOfOccurrence) {
                countOfOccurrence = count;
                output = ke;
            }
        }
        return output;
    }
}