import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 6};
        int test = maximumUniqueSubarray(nums);
        System.out.println(test);
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int maximumValue = 0;
        int currentSum = 0;
        HashSet<Integer> mySet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];

            while (mySet.contains(current)) {
                int leftNumber = nums[left];
                mySet.remove(leftNumber);
                currentSum -= leftNumber;
                left++;
            }

            mySet.add(current);
            currentSum += current;
            maximumValue = Math.max(currentSum, maximumValue);
        }

        return maximumValue;
    }


}
