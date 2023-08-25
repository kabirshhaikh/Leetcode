import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {0,10};
        int k = 2;
        int test = smallestRange1(nums, k);
        System.out.println(test);
    }

    public static int smallestRange1 (int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        // Initialize by considering the whole range as initial difference
        int initialDifference = nums[n - 1] - nums[0];

        // Find the optimal values to add to the smallest and subtract from the largest elements
        int smallest = nums[0] + k;
        int largest = nums[n - 1] - k;

        // Calculate the new difference after adjusting the smallest and largest values
        int newDifference = Math.max(0, largest - smallest);

        // Return the minimum of initialDifference and newDifference
        return Math.min(initialDifference, newDifference);
    }
}
