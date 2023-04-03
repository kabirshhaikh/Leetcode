import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {
        String[] test1 = {"Test", "Sh"};
        String[] test2 = {"Tnet", "Sh"};

    }

    public static boolean arrayStringsEqual (String[] word1, String[] word2) {
        ArrayList<Character> word1List = new ArrayList<>();
        ArrayList<Character> word2List = new ArrayList<>();
        for (int i=0; i<word1.length; i++) {
            String word = word1[i];
            char[] char1 = word.toCharArray();
            for (char c : char1) {
                word1List.add(c);
            }
        }
        for (int i=0; i<word2.length ; i++) {
            String word = word2[i];
            char[] ch2 = word.toCharArray();
            for (char ch: ch2) {
                word2List.add(ch);
            }
        }

        String concatenatedString1 = String.join("", word1List.stream().map(Object::toString).collect(Collectors.toList()));
        String concatenatedString2 = String.join("", word2List.stream().map(Object::toString).collect(Collectors.toList()));

        if (concatenatedString1.equals(concatenatedString2)) {
            return true;
        }
        else {
            return false;
        }
    }
}