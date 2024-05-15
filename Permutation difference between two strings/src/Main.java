public class Main {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "edbac";
        int test = findPermutationDifference(s, t);
        System.out.println(test);
    }


    public static int findPermutationDifference(String s, String t) {
        int difference = 0;

        for (int i=0; i<s.length(); i++) {
            char currentSChar = s.charAt(i);
            int diff = 0;
            for (int j=i+1; j<t.length(); j++) {
                char currentTChar = t.charAt(j);
                if (currentSChar == currentTChar) {
                    diff = Math.abs(i-j);
                    break;
                }
            }
            difference = difference + diff;
        }

        return difference * 2;
    }
}
