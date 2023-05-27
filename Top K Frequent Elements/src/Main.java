import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        topKFrequent(nums, k);
    }

    public static int[] topKFrequent (int[] nums, int k) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }
        List<Integer> myList = new ArrayList<>(myMap.keySet());
        myList.sort((a,b) -> myMap.get(b) - myMap.get(a));

        int[] output = new int[k];
        
        for (int i=0; i<k; i++) {
            int element = myList.get(i);
            output[i] = element;
        }
        System.out.println(Arrays.toString(output));
        return output;
    }

}