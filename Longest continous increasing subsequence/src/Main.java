import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3,5,4,7};
        int test = findLengthOfLCIS(nums);
        System.out.println(test);
    }



    public static int findLengthOfLCIS (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        ArrayList<ArrayList<Integer>> myList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                list.add(nums[i]);
            } else {
                myList.add(new ArrayList<>(list));
                list.clear();
                list.add(nums[i]);
            }
        }
        myList.add(new ArrayList<>(list));

        int maxLength = 0;
        for (ArrayList<Integer> seq : myList) {
            maxLength = Math.max(maxLength, seq.size());
        }

        return maxLength;
    }
}
