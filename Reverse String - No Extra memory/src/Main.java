import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        reverseString(c);
    }

    public static void reverseString (char[] s) {
        int i=0;
        int j= s.length-1;
        System.out.println("Before swapping:" + Arrays.toString(s));
        while (i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i = i+1;
            j = j-1;
        }
        System.out.println("After swapping: " + Arrays.toString(s));
    }

}