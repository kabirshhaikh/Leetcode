import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main (String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double test = findMedianSortedArrays(nums1, nums2);
        System.out.println(test);
    }


    public static double findMedianSortedArrays (int[] nums1, int[] nums2) {
        double median = 0;
        ArrayList<Integer> myList = new ArrayList<>();

        for (int i=0; i<nums1.length; i++) {
            myList.add(nums1[i]);
        }

        for (int i=0; i< nums2.length; i++) {
            myList.add(nums2[i]);
        }

        Collections.sort(myList);

        if (myList.size() % 2 == 0) {
            int middle1 = myList.size()/2 - 1;
            int middle2 = myList.size()/2;
            median = (myList.get(middle1) + myList.get(middle2)) / 2.0;
        }
        else {
            median = myList.get(myList.size() / 2);
        }

        return median;
    }
}
