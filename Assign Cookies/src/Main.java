import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        int test = findContentChildren(g, s);
        System.out.println(test);
    }

    public static int findContentChildren (int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length) {
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }
}