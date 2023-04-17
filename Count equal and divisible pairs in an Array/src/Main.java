public class Main {
    public static void main (String[] args) {
        int[] nums = {3,1,2,2,2,1,3};
        int k = 2;
        countPairs(nums, 2);
    }

    public static int countPairs (int[] nums, int k) {
        int divisibleByK = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++ ) {
                if (nums[i] == nums[j]) {
                    int index = (i*j);
                    if (index % k == 0) {
                        divisibleByK = divisibleByK + 1;
                    }
                }
            }
        }
        System.out.println("Count: " +divisibleByK);
        return divisibleByK;
    }


}