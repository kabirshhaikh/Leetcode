import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main (String[] args) {
        int[] nums = {2,2,1};
        singleNumber(nums);
    }


    public static int singleNumber (int[] nums) {
        int number = 0;
        for (int i=0; i<nums.length; i++) {
            int currentNumber = nums[i];
            number ^= currentNumber;
        }
        return number;
    }

}