public class Main {
    public static void main (String[] args) {
        String s = "";
        String t = "ahbgdc";
        isSubsequence(s, t);
    }


    public static boolean isSubsequence (String s, String t) {
            int i=0;
            int j = 0;
            while (i<s.length() && j<t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i != s.length()) {
                return false;
            }
            return true;
    }
}