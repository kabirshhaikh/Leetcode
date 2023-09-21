import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1};
        findDisappearedNumbers(nums);
    }

    public static List<Integer> findDisappearedNumbers (int[] nums) {
        ArrayList<Integer> myList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                myList.add(i + 1);
            }
        }

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        return myList;
    }
}