import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,2,3,2,2,2};
        divideArray(nums);
    }

    public static  boolean divideArray (int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int num : nums) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }
        for (int count : myMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }

}