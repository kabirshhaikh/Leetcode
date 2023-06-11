import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String s = "pwwkew";
        lengthOfLongestSubString(s);
    }


    public static int lengthOfLongestSubString (String s) {
        int left = 0;
        int answer = 0;
        HashSet<Character> mySet = new HashSet<>();
        for (int right=0; right<s.length(); right++) {
            char currentChar = s.charAt(right);
            if (mySet.contains(currentChar)) {
                while (s.charAt(left) != currentChar) {
                    mySet.remove(s.charAt(left));
                    left = left + 1;
                }
                left = left + 1;
            }
            else {
                mySet.add(currentChar);
            }
            answer = Math.max(answer, right - left + 1);
        }
        System.out.println("Answer: " +answer);
        return answer;
    }

}