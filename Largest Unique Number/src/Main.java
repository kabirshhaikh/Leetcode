import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int[] nums = {5,7,3,9,4,9,8,3,1};
        largestNumber(nums);
    }

    public static int largestNumber (int[] nums) {
        int largestNumber = Integer.MIN_VALUE;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber,0) +1);
        }
        int largestKey = 0;
        for (int key : myMap.keySet()) {
            if (key > largestKey) {
                largestKey = key;
            }
        }
        for (int key : myMap.keySet()) {
            int value = myMap.get(key);
            if (value == 1 && key == largestKey) {
                largestNumber = largestKey;
            }
        }
        for (int key = largestKey ; key >=0; key--) {
            int value = myMap.getOrDefault(key, 0);
            if (value == 1) {
                largestNumber = key;
                break;
            }
        }
        System.out.println("Largest Number:" +largestNumber);
        if (largestNumber != Integer.MIN_VALUE) {
            return largestNumber;
        }
        else {
            return -1;
        }
    }

}