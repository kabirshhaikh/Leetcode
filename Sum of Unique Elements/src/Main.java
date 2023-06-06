import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,2};
        sumOfUnique(nums);
    }

    public static int sumOfUnique (int[] nums) {
        int uniqueNumber = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (counter.get(num) == 1) {
                uniqueNumber += num;
            }
        }
        System.out.println("Unique Number Sum:" +uniqueNumber);
        return  uniqueNumber;
    }
}