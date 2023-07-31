import java.util.Arrays;

public class Main {
    public static void main (String[] test) {
        String s = "a-bC-dEf-ghIj";
        String t = reverseOnlyLetters(s);
        System.out.println(t);
    }

    public static String reverseOnlyLetters (String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }

        return ans.toString();
    }

}
