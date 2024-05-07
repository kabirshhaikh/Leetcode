public class Main {
    public static void main (String[] args) {
        int n = 9;
        boolean test = isStrictPalindromic(n);
        System.out.println(test);
    }



    public static boolean isStrictPalindromic (int n) {
        for (int i=1; i<n; i++) {
            String currentNumber = Integer.toBinaryString(i);
            int left = 0; int right = currentNumber.length()-1;

            while (left <= right) {
                if (currentNumber.charAt(left) != currentNumber.charAt(right)) {
                    return false;
                }
                else {
                    left = left + 1;
                    right = right - 1;
                }
            }

        }

        return true;
    }
}
