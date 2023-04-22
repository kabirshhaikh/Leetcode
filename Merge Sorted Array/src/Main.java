import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] num1 = {-1,0,0,3,3,3,0,0,0};
        int[] num2 = {1,2,2};
        int m = 6;
        int n= 3;
        merge(num1, m, num2, n);
    }

    public static void merge (int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> myList = new ArrayList<>();
       for (int i=0; i<m; i++) {
           myList.add(nums1[i]);
       }

        for (int i=0; i<n; i++) {
            myList.add(nums2[i]);
        }
        for (int i=0; i< myList.size(); i++) {
            nums1[i] = myList.get(i);
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }



}