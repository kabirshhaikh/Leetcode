import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int[] nums = {3,3,4,7,8};
        int d = 5;
        int test = divisibleTripletCount(nums, d);
        System.out.println(test);
    }

    public static int divisibleTripletCount (int[] nums, int d) {
        int n = nums.length;
        var map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int i = 2; i < n; i++) {
            int prev = nums[i - 1] % d;
            for (int j = i - 2; j >= 0; j--) {
                int v = (nums[j] + prev) % d;
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
            int v = nums[i] % d;
            ans += (v == 0) ? map.getOrDefault(0, 0) : map.getOrDefault(d - v, 0);
        }
        return ans;
    }
}