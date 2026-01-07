import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int test = characterReplacement(s, k);
        System.out.println(test);
    }

    private static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int best = 0;
        int maxFreq = 0;

        while (right < s.length()) {
            //capture element:
            char toAdd = s.charAt(right);

            //add captured element into map:
            map.put(toAdd, map.getOrDefault(toAdd, 0) + 1);

            //check the count of captured element, if > maxFreq then replace:
            maxFreq = Math.max(maxFreq, map.get(toAdd));

            //move right pointer:
            right++;

            //Now shrink window when condition is not valid and increment left:
            while ((right - left) - maxFreq > k) {
                //capture element to remove:
                char toRemove = s.charAt(left);

                //remove captured element from map:
                map.put(toRemove, map.get(toRemove) - 1);

                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }

                //increment left pointer:
                left++;
            }

            //update the ans:
            best = Math.max(best, right - left);
        }

        return best;
    }
}
