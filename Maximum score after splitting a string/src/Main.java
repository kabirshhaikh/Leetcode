public class Main {
    public static void main (String[] args) {
        String s = "011101";
        int test = maxScore(s);
        System.out.println(test);
    }

    //Optimized approach:
    public static int maxScore (String s) {
        int maxScore = Integer.MIN_VALUE;
        int[] leftZeros = zeroPrefix(s);
        int[] rightOnes = onePrefix(s);

        for (int i=0; i<s.length() - 1; i++) {
            int numberOfZeros = leftZeros[i];
            int numberOfOnes = rightOnes[i+1];

            int score = numberOfZeros + numberOfOnes;

            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }

    public static int[] zeroPrefix (String s) {
        int[] zeroPrefix = new int[s.length()];
        zeroPrefix[0] = s.charAt(0) == '0' ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            zeroPrefix[i] = zeroPrefix[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        return zeroPrefix;
    }

    public static int[] onePrefix (String s) {
        int[] oneSuffix = new int[s.length()];
        oneSuffix[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0; // Initialize last value

        for (int i = s.length() - 2; i >= 0; i--) {
            oneSuffix[i] = oneSuffix[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        return oneSuffix;
    }


    //Brute force:
//    public static int maxScore (String s) {
//        int maxScore = Integer.MIN_VALUE;
//        StringBuilder leftString = new StringBuilder();
//
//        for (int i=0; i<s.length() - 1; i++) {
//            leftString.append(s.charAt(i));
//            int numberOfZeroes = leftZeroes(leftString.toString());
//            int numberOfOnes = 0;
//            for (int j=i+1; j<s.length(); j++) {
//                if (s.charAt(j) == '1') {
//                    numberOfOnes++;
//                }
//            }
//            maxScore = Math.max(maxScore, numberOfZeroes + numberOfOnes);
//        }
//
//        return maxScore;
//    }
//
//
//    public static int leftZeroes (String s) {
//        int output = 0;
//
//        for (int i=0; i<s.length(); i++) {
//            char currentChar = s.charAt(i);
//            if (currentChar == '0') {
//                output++;
//            }
//        }
//
//        return output;
//    }

}
