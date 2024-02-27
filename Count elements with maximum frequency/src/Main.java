import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,2,3,1,4};
        int test = maxFrequencyElements(nums);
        System.out.println(test);
    }


    public static int maxFrequencyElements (int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }

        int maxFreq = -1;

        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int count = map.getValue();
            if (count > maxFreq) {
                maxFreq = count;
            }
        }

        int maximumFrequency = 0;
        for (Map.Entry<Integer, Integer> map: myMap.entrySet()) {
            int count = map.getValue();
            if (count == maxFreq) {
                maximumFrequency = maximumFrequency + count;
            }
        }


        return maximumFrequency;
    }
}