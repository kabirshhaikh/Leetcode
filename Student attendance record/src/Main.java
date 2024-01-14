public class Main {
    public static void main (String[] args) {
        String s = "PPALLL";
        boolean test = checkRecord(s);
        System.out.println(test);
    }


    public static boolean checkRecord (String s) {
        int aCount = 0;

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == 'A') {
                aCount = aCount + 1;
            }
            if (i<=s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L') {
                return false;
            }
        }

        if (aCount < 2) {
            return true;
        }
        else {
            return false;
        }
    }
}