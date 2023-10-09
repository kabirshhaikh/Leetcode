import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[] nums1 = {3,5,2,6};
        int[] nums2 = {3,1,7};
        int test = minNumber(nums1, nums2);
        System.out.println(test);
    }

    public static int minNumber (int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a=nums1[0];
        int b=nums2[0];
        HashSet<Integer> hs1=new HashSet<>();
        HashSet<Integer> hs2=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hs1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            hs2.add(nums2[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(hs1.contains(nums2[i]))
                return nums2[i];
        }
        if(a==b)
            return a;

        if(a<b)
            return (a*10)+b;

        return (b*10)+a;
    }
}