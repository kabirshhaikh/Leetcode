import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] test) {
        String s = "Hello how are you contestant";
        int k=4;
        truncateSentence(s, k);
    }

    public static String truncateSentence (String s, int k) {
        String[] words = s.split(" ");
        ArrayList<String>myList = new ArrayList<>();
        for (int i=0; i<k; i++) {
            myList.add(words[i]);
        }
        String output = String.join(" ", myList);
        return output;
    }



}