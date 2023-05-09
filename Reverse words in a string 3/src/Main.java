import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String s = "Let's take LeetCode contest";
        reverseWords(s);
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        ArrayList<Character> myList = new ArrayList<>();
        for (int i=0; i<words.length; i++) {
            String currentWord = words[i];
            for (int j=currentWord.length() -1 ; j>=0; j--) {
                char ch = currentWord.charAt(j);
                myList.add(ch);
            }
            if (i < words.length -1) {
                myList.add(' ');
            }
        }
        StringBuilder reveredString = new StringBuilder(myList.size());
        for (char ch : myList) {
            reveredString.append(ch);
        }
        System.out.println(reveredString.toString());
        return reveredString.toString();
    }


}