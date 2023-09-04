public class Main {
    public static void main (String[] args) {
        int[] nums = {1,5,2,4,1};
        int test = minOperations(nums);
        System.out.println(test);
    }

    public static int minOperations (int[] nums) {
        int operations = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] >= nums[i+1]) {
                int difference = nums[i] - nums[i+1] +1;
                operations = operations + difference;
                nums[i+1] = nums[i] + 1;
            }
        }
        return operations;
    }
}