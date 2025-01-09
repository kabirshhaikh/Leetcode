import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
//        int[] nums1 = {1,2};
//        int[] nums2 = {-2,-1};
//        int[] nums3 = {-1,2};
//        int[] nums4 = {0,2};
        int[] nums1 = {0};
        int[] nums2 = {0};
        int[] nums3 = {0};
        int[] nums4 = {0};
        int test = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(test);
    }



    public static int fourSumCount (int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int output = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        for (int i=0; i< nums1.length; i++) {
            for (int j=0; j< nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i=0; i< nums3.length; i++) {
            for (int j=0; j<nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                int freq = sumMap.getOrDefault(-sum, 0);
                if (freq > 0) {
                    output = output + freq;
                }
            }
        }


        return output;
    }
}