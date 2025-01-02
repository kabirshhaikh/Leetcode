import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        String s = "eceba";
        int k = 2;
        int test = lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(test);
    }



    public static int lengthOfLongestSubstringKDistinct (String s, int k) {
        int longest = 0;
        int left = 0;
        HashMap<Character, Integer> myMap = new HashMap<>();

        for (int right=0; right<s.length(); right++) {
            char currentChar = s.charAt(right);
            myMap.put(currentChar, myMap.getOrDefault(currentChar, 0) + 1);

            while (myMap.size() > k) {
                char charAtLeft = s.charAt(left);
                int countOfCharAtLeft = myMap.get(charAtLeft);

                if (countOfCharAtLeft == 1) {
                    myMap.remove(charAtLeft);
                }
                else {
                    myMap.put(charAtLeft, countOfCharAtLeft - 1);
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}