public class Main {
    public static void main (String[] args) {
        String s= "zaz";
        int test = scoreOfString(s);
        System.out.println(test);
    }



    public static int scoreOfString (String s) {
        int sum = 0;

        for (int i=0; i<s.length()-1; i++) {
            char currentChar = s.charAt(i);
            char nextChar = s.charAt(i+1);
            int valOfCurrent = (int) currentChar;
            int valOfNext = (int) nextChar;
            int value = Math.abs(valOfCurrent - valOfNext);
            sum = sum + value;
        }

        return sum;
    }
}