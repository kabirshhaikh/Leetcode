public class Main {
    public static void main (String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        strStr(haystack, needle);
    }

    public static int strStr (String haystack, String needle) {
        int i=0;
        int j=0;
        if (needle.isEmpty()) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        while (i<haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i = i+1;
                j = j+1;
            }
            else {
                i = i-j+1;
                j = 0;
            }
            if (j == needle.length()) {
                return i-j;
            }
        }
        return -1;
    }

}