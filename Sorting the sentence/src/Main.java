import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String s = "is2 sentence4 This1 a3";
        sortSentence(s);
    }

    public static String sortSentence (String s) {
        String[] words = s.split(" ");
        String[] output = new String[words.length];
        for (int i=0; i<words.length; i++) {
            String currentWord = words[i];
            String filteredWord = "";
            int number = 0;
            for (int j=0; j<currentWord.length(); j++) {
                char lastCharacterOfCurrentWord = currentWord.charAt(currentWord.length()-1);
                number = Character.getNumericValue(lastCharacterOfCurrentWord);
                while (j<currentWord.length()-1) {
                    filteredWord += currentWord.charAt(j);
                    j++;
                }
            }
            output[number-1] = filteredWord;
        }
        String sentence = String.join(" ",output );
        System.out.println(sentence);
        return sentence;
    }

}
