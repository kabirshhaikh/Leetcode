public class Main {
    public static void main (String[] args) {
        int k = 18;
        int[] nums = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        numSubarrayProductLessThanK(nums, k);
    }

    public static int numSubarrayProductLessThanK (int[] nums, int k) {
        if (k<=1) {
            return 0;
        }
        int left = 0;
        int answer = 0;
        int current = 1;
        for (int right=0; right<nums.length; right++) {
            current = current * nums[right];
            while (current >= k && left<right) {
                current /= nums[left];
                left = left + 1;
            }
            if (current < k) {
                answer = answer + right - left + 1;
            }
        }
        System.out.println("Answer:" +answer);
        return answer;
    }

}