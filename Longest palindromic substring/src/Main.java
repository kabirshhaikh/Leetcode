public class Main {
    public static void main (String[] args) {
        String s = "babad";
        String test = longestPalindrome(s);
        System.out.println(test);
    }

    public static String longestPalindrome (String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            String palindrome1 = expandAroundCenter(s, i, i);
            String palindrome2 = expandAroundCenter(s, i, i + 1);

            if (palindrome1.length() > longest.length()) {
                longest = palindrome1;
            }
            if (palindrome2.length() > longest.length()) {
                longest = palindrome2;
            }
        }

        return longest;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

}