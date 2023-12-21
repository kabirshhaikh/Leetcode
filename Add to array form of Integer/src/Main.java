import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] testt) {
        int[] num = {1,2,0,0};
        int k = 34;
        addToArrayForm(num, k);
    }

    public static List<Integer> addToArrayForm (int[] num, int k) {
        int N = num.length;
        int cur = k;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += num[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
}