public class Main {
    public static void main (String[] args) {
        String s = "ab";
        String goal = "ba";
        buddyStrings(s, goal);
    }
    public static boolean buddyStrings (String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
                if (charCount[c - 'a'] >= 2) {
                    return true;
                }
            }
            return false;
        }

        int firstDiff = -1;
        int secondDiff = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstDiff == -1) {
                    firstDiff = i;
                } else if (secondDiff == -1) {
                    secondDiff = i;
                } else {
                    return false;
                }
            }
        }

        return (secondDiff != -1 && s.charAt(firstDiff) == goal.charAt(secondDiff) &&
                s.charAt(secondDiff) == goal.charAt(firstDiff));
    }
}
