public class Main {
    public static void main (String[] args) {
        int[] nums = {12,6,1,2,7};
        long test = maximumTripletValue(nums);
        System.out.println(test);
    }


    public static long maximumTripletValue (int[] nums) {
        long maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long tempVal = (long)(nums[i] - nums[j]) * nums[k];
                    if (tempVal > maxVal) {
                        maxVal = tempVal;
                    }
                }
            }
        }

        if (maxVal <= 0) {
            return 0;
        } else {
            return maxVal;
        }
    }
}
