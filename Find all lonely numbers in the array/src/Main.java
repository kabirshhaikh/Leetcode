import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 6, 5, 8};
        List<Integer> test = findLonely(nums);
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + ", ");
        }
    }


    public static List<Integer> findLonely(int[] nums) {
        List<Integer> myList = new ArrayList<>();
        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            myMap.put(number, myMap.getOrDefault(number, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if ((myMap.get(number) == 1) && (!myMap.containsKey(number - 1)) && (!myMap.containsKey(number + 1))) {
                myList.add(number);
            }
        }

        return myList;
    }
}
