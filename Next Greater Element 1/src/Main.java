import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] test = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(test));
    }


    public static int[] nextGreaterElement (int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int currentNum1 = nums1[i];
            boolean found = false;
            int j = 0;

            while (j < nums2.length) {
                if (nums2[j] == currentNum1) {
                    found = true;
                    break;
                }
                j++;
            }

            if (found) {
                int nextGreater = -1;
                for (int k = j + 1; k < nums2.length; k++) {
                    if (nums2[k] > currentNum1) {
                        nextGreater = nums2[k];
                        break;
                    }
                }
                output[i] = nextGreater;
            }
        }

        return output;
    }

}

