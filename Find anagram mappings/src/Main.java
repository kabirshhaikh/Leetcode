import java.util.Arrays;
public class Main {
    public static void main (String[] args) {
        int[] nums1 = {12,28,46,32,50};
        int[] nums2 = {50,12,32,46,28};
        int[] test = anagramMappings(nums1, nums2);
        System.out.println(Arrays.toString(test));
    }
    public static int[] anagramMappings (int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            int currentNumber = nums1[i];
            for (int j=0; j<nums2.length; j++) {
                if (currentNumber == nums2[j]) {
                    output[i] = j;
                    break;
                }
            }
        }
        return output;
    }
}