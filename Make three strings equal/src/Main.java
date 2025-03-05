public class Main {
    public static void main (String[] args) {
        String s1 = "abc";
        String s2 = "abb";
        String s3 = "ab";
        int test = findMinimumOperations(s1, s2, s3);
        System.out.println(test);
    }
    
    private static int findMinimumOperations (String s1, String s2, String s3) {
        int commonLength = longestCommonPrefix(s1, s2, s3);

        if (commonLength < 1) {
            return -1;
        }

        if (s1.charAt(0) != s2.charAt(0) && s2.charAt(0) != s3.charAt(0)) {
            return -1;
        }

        int operations = (s1.length() - commonLength) + (s2.length() - commonLength) + (s3.length() - commonLength);

        return operations;
    }

    private static int longestCommonPrefix (String s1, String s2, String s3) {
        int min = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        int i = 0;

        while (i < min && s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
            i++;
        }

        return i;
    }
}
