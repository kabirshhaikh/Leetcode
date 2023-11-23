import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        int[] nums = {42,11,1,97};
        int test = countNicePairs(nums);
        System.out.println(test);
    }


    public static int countNicePairs (int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }

        Map<Integer, Integer> dic = new HashMap();
        int ans = 0;
        int MOD = (int) 1e9 + 7;
        for (int num : arr) {
            ans = (ans + dic.getOrDefault(num, 0)) % MOD;
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }

        return ans;
    }


    public static int rev (int x) {
        String temp = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i=temp.length() - 1; i>=0; i--) {
            sb.append(temp.charAt(i));
        }
        int output = Integer.parseInt(sb.toString());
        return output;
    }

}
