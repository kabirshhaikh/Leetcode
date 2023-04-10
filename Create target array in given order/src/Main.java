import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        createTargetArray(nums, index);
    }



    public static int[] createTargetArray (int[] nums, int[] index) {
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i=0; i< index.length; i++) {
            int currentIndex = index[i];
           if (currentIndex >= myList.size()) {
               myList.add(nums[i]);
           }
           else {
               myList.add(currentIndex, nums[i]);
           }
        }
        int[] target = new int[myList.size()];
        for (int i=0; i<target.length; i++) {
            target[i] = myList.get(i);
        }
        System.out.println(Arrays.toString(target));
        return target;
    }


}