import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6};
        int test = tupleSameProduct(nums);
        System.out.println(test);
    }

    public static int tupleSameProduct(int[] nums) {
        HashMap<Integer, List<int[]>> myMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                int[] curr = new int[]{nums[i], nums[j]};
                myMap.computeIfAbsent(product, k -> new ArrayList<>()).add(curr);
            }
        }

        int count = 0;

        for (Map.Entry<Integer, List<int[]>> map : myMap.entrySet()) {
            List<int[]> pairs = map.getValue();

            for (int i = 0; i < pairs.size(); i++) {
                for (int j = i + 1; j < pairs.size(); j++) {
                    int[] p1 = pairs.get(i);
                    int[] p2 = pairs.get(j);
                    if (p1[0] != p2[0] && p1[0] != p2[1] && p1[1] != p2[0] && p1[1] != p2[1]) {
                        count++;
                    }
                }
            }
        }


        return count * 8;
    }
}
