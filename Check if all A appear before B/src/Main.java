public class Main {
    public static void main (String[] args) {
        String s = "aaaaabbbbb";
        boolean test = checkString(s);
        System.out.println(test);
    }

    public static boolean checkString (String s) {
        for (int i=0; i<s.length()-1; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == 'b' && s.charAt(i+1) == 'a') {
                return false;
            }
        }
        return true;
    }
}