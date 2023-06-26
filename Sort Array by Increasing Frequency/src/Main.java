import java.util.*;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,1,2,2,2,3};
        frequencySort(nums);
    }

    public static int[] frequencySort (int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int n : nums) {
            ans.add(n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Collections.sort(ans, (a, b) ->
                (map.get(a) == map.get(b))? b - a : map.get(a) - map.get(b)
        );

        return ans.stream().mapToInt(i -> i).toArray();
    }

}