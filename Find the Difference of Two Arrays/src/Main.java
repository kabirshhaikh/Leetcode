import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        findDifference(nums1, nums2);
    }


    public static List<List<Integer>> findDifference (int[] nums1, int[] nums2) {
        List<List<Integer>> myList = new ArrayList<>(2);
        HashSet<Integer> mySet1 = new HashSet<>();
        HashSet<Integer> mySet2 = new HashSet<>();
        for (int i=0; i<nums1.length; i++) {
            int count = 0;
            for (int j=0; j<nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    count = count + 1;
                }
            }
            if (count == 0) {
                mySet1.add(nums1[i]);
            }
        }
        for (int i=0; i<nums2.length; i++) {
            int count = 0;
            for (int j=0; j< nums1.length; j++) {
                if (nums2[i] == nums1[j]) {
                    count++;
                }
            }
            if (count == 0) {
                mySet2.add(nums2[i]);
            }
        }
        ArrayList<Integer> myList1 = new ArrayList<>();
        ArrayList<Integer> myList2 = new ArrayList<>();
        for (int nums: mySet1) {
            myList1.add(nums);
        }
        for (int nums : mySet2) {
            myList2.add(nums);
        }
        myList.add(myList1);
        myList.add(myList2);
        return myList;
    }

}
