import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2};
        majorityElement(nums);
    }


    public static List<Integer> majorityElement (int[] nums) {
        List<Integer> myList = new ArrayList<>();
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            myMap.put(currentNumber, myMap.getOrDefault(currentNumber, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> map: myMap.entrySet()) {
            int key = map.getKey();
            int count = map.getValue();
            if (count > nums.length/3 ) {
                myList.add(key);
            }
        }

        return myList;
    }
}
