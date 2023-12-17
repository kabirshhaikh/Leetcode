public class Main {
    public static void main (String[] args) {
        String s = "abca";
        int test = maxLengthBetweenEqualCharacters(s);
        System.out.println(test);
    }



    public static int maxLengthBetweenEqualCharacters (String s) {
        int maxLength = Integer.MIN_VALUE;

        for (int i=0; i<s.length(); i++) {
            char leftChar = s.charAt(i);
            int rightPointer = i + 1;
            while (rightPointer < s.length()) {
                char rightChar = s.charAt(rightPointer);
                if (leftChar == rightChar) {
                    int currentLength = rightPointer - i - 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                }
                rightPointer = rightPointer + 1;
            }
        }

        if (maxLength == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return maxLength;
        }
    }
}
