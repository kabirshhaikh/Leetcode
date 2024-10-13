import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String s = "ccaabbb";
        int test = lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(test);
    }



    public static int lengthOfLongestSubstringTwoDistinct (String s) {
        int length = 0;
        HashMap<Character, Integer> myMap = new HashMap<>();
        int right = 0;
        int left = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            myMap.put(currentChar, myMap.getOrDefault(currentChar, 0) + 1);

            while (myMap.size() > 2) {
                char leftChar = s.charAt(left);
                myMap.put(leftChar, myMap.get(leftChar) - 1);
                if (myMap.get(leftChar) == 0) {
                    myMap.remove(leftChar);
                }
                left = left + 1;
            }
            length = Math.max(length, right - left + 1);
            right = right + 1;
        }

        return length;
    }
}