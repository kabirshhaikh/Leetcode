import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums1 = {2,1,3};
        int[] nums2 = {10,2,5,0};
        int test = xorAllNums(nums1, nums2);
        System.out.println(test);
    }


    public static int xorAllNums (int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;

        for (int num : nums1) {
            xor1 ^= num;
        }

        for (int num : nums2) {
            xor2 ^= num;
        }

        int result = 0;
        if (nums1.length % 2 != 0) {
            result ^= xor2;
        }
        if (nums2.length % 2 != 0) {
            result ^= xor1;
        }

        return result;
    }

}
