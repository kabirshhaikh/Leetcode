import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        int test = takeCharacters(s, k);
        System.out.println(test);
    }


    public static int takeCharacters (String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int n = s.length();
        int minLength = n;

        HashMap<Character, Integer> totalCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            totalCount.put(c, totalCount.getOrDefault(c, 0) + 1);
        }

        for (char c : "abc".toCharArray()) {
            if (totalCount.getOrDefault(c, 0) < k) {
                return -1;
            }
        }

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while (map.getOrDefault('a', 0) > totalCount.getOrDefault('a', 0) - k ||
                    map.getOrDefault('b', 0) > totalCount.getOrDefault('b', 0) - k ||
                    map.getOrDefault('c', 0) > totalCount.getOrDefault('c', 0) - k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }


            minLength = Math.min(minLength, n - (right - left + 1));
        }

        return minLength;
    }
}
