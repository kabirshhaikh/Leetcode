public class Main {
    public static void main (String[] args) {
        int[] nums = {1,5,2,10};
        int test = maximumDifference(nums);
        System.out.println(test);
    }

    public static int maximumDifference (int[] nums) {
        int maxDifference = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
           for (int j=i+1; j<nums.length; j++) {
               if (nums[i] < nums[j]) {
                   int difference = nums[j] - nums[i];
                   if (difference > maxDifference) {
                       maxDifference = difference;
                   }
               }
           }
        }
        if (maxDifference == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return maxDifference;
        }
    }
}
