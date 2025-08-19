public class Main {
    public static void main(String[] args) {
        int[] nums = {2,10,2019};
        long test = zeroFilledSubarray(nums);
        System.out.println(test);
    }

    public static long zeroFilledSubarray(int[] nums) {
        long output = 0;
        long subarray = 0;

        if (nums.length !=0 && nums[0] == 0) {
            output++;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) output++;

            if (nums[i - 1] == 0 && nums[i] == 0) {
                subarray++;
                output += subarray;
            }
            else {
                subarray = 0;
            }
        }

        return output;
    }
}
