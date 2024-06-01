import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main (String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] sortedArray = sortArray(nums);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] sortArray (int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        // 1. Find the maximum and minimum values in the array
        int minValue = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            } else if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        // 2. Create buckets
        int bucketCount = (maxValue - minValue) / nums.length + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // 3. Distribute the array elements into buckets
        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - minValue) / nums.length;
            buckets[bucketIndex].add(nums[i]);
        }

        // 4. Sort each bucket
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets[i]);
        }

        // 5. Concatenate all buckets into nums[]
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            for (int num : buckets[i]) {
                nums[index++] = num;
            }
        }

        return nums;
    }
}
