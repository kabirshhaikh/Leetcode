public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,2,1};
        int k = 1;
        countKDifference(nums, k);
    }


    public static int countKDifference (int[] nums, int k) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int subtractedValue = nums[i] - nums[j];
                if (Math.abs(subtractedValue) == k) {
                    count = count + 1;
                }
            }
        }
        System.out.println("Count: " +count);
        return count;
    }


}