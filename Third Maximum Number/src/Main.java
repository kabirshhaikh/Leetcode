public class Main {
    public static void main (String[] args) {
        int[] nums = {3,2,1};
        int test = thirdMax(nums);
        System.out.println(test);
    }

    public static int thirdMax (int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for (int num : nums) {
            if (firstMax == num || secondMax == num || thirdMax == num) {
                continue;
            }
            if (firstMax <= num) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            }
            else if (secondMax <= num) {
                thirdMax = secondMax;
                secondMax = num;
            }
            else if (thirdMax <= num) {
                thirdMax = num;
            }
        }
        if (thirdMax == Long.MIN_VALUE) {
            int ans = (int) firstMax;
            return ans;
        }
        int ans = (int) thirdMax;
        return ans;
    }
}