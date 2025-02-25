public class Main {
    public static void main (String[] args) {
        int[] nums1 = {1,2,4,12};
        int[] nums2 = {2,4};
        int k = 3;
        int test = numberOfPairs(nums1, nums2, k);
        System.out.println(test);
    }


    public static int numberOfPairs (int[] nums1, int[] nums2, int k) {
        int pairs = 0;

        for (int i=0; i<nums1.length; i++) {
            for (int j=0; j< nums2.length; j++) {
                int num = nums2[j] * k;
                if (nums1[i] % num == 0) {
                    pairs++;
                }
            }
        }

        return pairs;
    }
}
