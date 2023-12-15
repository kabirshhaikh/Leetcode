 public class Main {
        public static void main (String[] args) {
            int[] nums = {3,6,1,0};
            int test = dominantIndex(nums);
            System.out.println(test);
        }

        public static int dominantIndex (int[] nums) {
            int maxIndex = 0;
            int largestNumber = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > largestNumber) {
                    largestNumber = nums[i];
                    maxIndex = i;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (i != maxIndex && largestNumber < 2 * nums[i]) {
                    return -1;
                }
            }

            return maxIndex;
        }

    }