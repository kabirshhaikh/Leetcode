public class Main {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        int test = maximizeSum(nums, k);
        System.out.println(test);
    }

    public static int maximizeSum (int[] nums, int k) {
        int largestNumber = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber > largestNumber) {
                largestNumber = currentNumber;
            }
        }
        while(k>0){
            ans+=largestNumber;
            largestNumber = largestNumber+1;
            k--;
        }
        return ans;
    }
}