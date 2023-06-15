import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String s = "  hello world  ";
        reverseWord(s);
    }


    public static String reverseWord (String s) {
        String[] string = s.trim().split("\\s+");
        int left = 0;
        int right = string.length - 1;
        while (left < right) {
            String temp = string[left];
            string[left] = string[right];
            string[right] = temp;
            left = left + 1;
            right = right - 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<string.length ; i++) {
            String word = string[i];
            if (i < string.length - 1) {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            else {
                stringBuilder.append(word);
            }
        }
        String output = stringBuilder.toString();
        System.out.println(output);
        return output;
    }

}