public class Main {
    public static void main (String[] args) {
        String s = "abcdef";
        boolean test = makePalindrome(s);
        System.out.println(test);
    }


    public static boolean makePalindrome (String s) {
        int count = 0;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar != rightChar) {
                count = count + 1;
            }

            left = left + 1;
            right = right - 1;
        }

        return count <= 2;
    }
}
