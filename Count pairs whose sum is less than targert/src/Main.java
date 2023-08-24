import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(1);
        int target = 2;
        countPairs(nums, target);
    }

    public static int countPairs (List<Integer> nums, int target) {
        int count = 0;
        for (int i=0; i<nums.size(); i++) {
            int j = i+1;
            while (j < nums.size()) {
                if (nums.get(i) + nums.get(j) < target) {
                    count = count + 1;
                }
                j++;
            }
        }
        System.out.println(count);
        return count;
    }
}