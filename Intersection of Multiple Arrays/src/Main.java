import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[][] nums = {{3,1,2,4,5}, {1,2,3,4}, {3,4,5,6}};
        intersection(nums);
    }

    public static List<Integer> intersection (int[][] nums) {
        List<Integer> myList = new ArrayList<>();
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            int[] currentArray = nums[i];
            count = count + 1;
            for (int j=0; j<currentArray.length; j++) {
                int currentNumber = currentArray[j];
                myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) +1);
            }
        }
        for (Map.Entry<Integer, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            int key = map.getKey();
            if (value == count) {
                myList.add(key);
            }
        }
        Collections.sort(myList);
        return myList;
    }

}