import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean test = isAnagram(s, t);
        System.out.println(test);
    }

    public static boolean isAnagram (String s, String t) {
       char[] sArray = s.toCharArray();
       char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
       int i=0; int j=0;
        while (i<sArray.length && j< tArray.length) {
            char sArrayChar = sArray[i];
            char tArrayChar = tArray[j];
            if (sArrayChar == tArrayChar) {
                i++;
                j++;
            }
            else {
                return false;
            }
        }
        return true;
    }

}