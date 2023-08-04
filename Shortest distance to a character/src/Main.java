import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] test = shortestToChar(s, c);
        System.out.println(Arrays.toString(test));
    }



    public static int[] shortestToChar (String s, char c) {
        int N = s.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

}