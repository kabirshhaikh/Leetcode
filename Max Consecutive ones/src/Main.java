public class Main {
    public static void main (String[] args) {
        int[] nums = {1,0,1,1,0,1};
        int test = findMaxConsecutiveOnes(nums);
        System.out.println(test);
    }

    public static int findMaxConsecutiveOnes (int[] nums) {
        int output = 0;

        for (int i=0; i<nums.length; i++) {
            int tempConsecutiveOnes = 0;
            int currentNumber = nums[i];
            int j = i;
            if (currentNumber == 1) {
                while (j<nums.length) {
                    if (nums[j] == 1) {
                        tempConsecutiveOnes = tempConsecutiveOnes + 1;
                        j = j+1;
                    }
                    else {
                        break;
                    }
                }
                if (tempConsecutiveOnes > output) {
                    output = tempConsecutiveOnes;
                }
            }
        }

        return output;
    }

}
