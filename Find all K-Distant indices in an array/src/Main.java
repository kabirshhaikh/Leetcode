import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,4,9,1,3,9,5};
        int key = 9;
        int k = 1;
        findKDistantIndices(nums, key, k);
    }

    public static List<Integer> findKDistantIndices (int[] nums, int key, int k) {
        List<Integer> al = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int index = -1;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] == key && Math.abs(i - j) <= k) {
                    index = i;
                }
            }
            if(index != -1) {
                al.add(index);
            }
        }
        return al;
    }
}