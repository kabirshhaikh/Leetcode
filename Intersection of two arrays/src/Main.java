import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersetion(nums1, nums2);
    }

    public static int[] intersetion (int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        HashSet<Integer> mySet = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i<nums1.length && j < nums2.length ) {
            if (nums1[i] == nums2[j]) {
                mySet.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        int[] result = new int[mySet.size()];
        int index = 0;
        for (Integer elements : mySet) {
            result[index++] = elements;
        }
        System.out.println("Reult:" +Arrays.toString(result));
        return result;
    }

}