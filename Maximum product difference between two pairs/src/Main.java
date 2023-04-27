import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {5,6,2,7,4};
        maxProductDifference(nums);
    }

    public static int maxProductDifference (int[] nums) {
        int difference = 0;
      int largestNumber1 = Integer.MIN_VALUE;
      int largestNumber2 = Integer.MIN_VALUE;
      int smallestNumber1 = Integer.MAX_VALUE;
      int smallestNumber2 = Integer.MAX_VALUE;

      for (int i=0; i<nums.length; i++) {
          if (nums[i] >largestNumber1) {
              largestNumber2 = largestNumber1;
              largestNumber1 = nums[i];
          }
          else if (nums[i] > largestNumber2) {
              largestNumber2 = nums[i];
          }

          if (nums[i] < smallestNumber1) {
              smallestNumber2 = smallestNumber1;
              smallestNumber1 = nums[i];
          }
          else if (nums[i] <smallestNumber2) {
              smallestNumber2 = nums[i];
          }
      }
        difference = (largestNumber1 * largestNumber2) - (smallestNumber1 * smallestNumber2);
        System.out.println("Difference: " + difference);
      return difference;
    }

}