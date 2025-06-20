public class Main {
    public static void main (String[] args) {
        int[] nums = {0,1,1,1,0,0};
        int test = minOperations(nums);
        System.out.println(test);
    }

    public static int minOperations (int[] nums) {
        int n = nums.length;
        int windowSize = 3;
        int steps = 0;

        //Outer loop:
        for (int i=0; i<=n - windowSize; i++) {
           if (nums[i] == 0) {
               for (int j=i; j<i+windowSize; j++) {
                   nums[j] ^= 1;
               }
               steps++;
           }
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }

        return steps;
    }
}
