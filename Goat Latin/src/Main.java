import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String sentence = "I speak Goat Latin";
        String test = toGoatLatin(sentence);
        System.out.println(test);
    }

    public static String toGoatLatin (String sentence) {
        String[] words = sentence.split(" ");
        ArrayList<String> myList = new ArrayList<>();
        for (int i=0; i<words.length; i++) {
            String currentWord = words[i];
            StringBuilder sb = new StringBuilder(currentWord);
            if (currentWord.charAt(0) == 'a' || currentWord.charAt(0) == 'e' || currentWord.charAt(0) == 'i' || currentWord.charAt(0) == 'o' || currentWord.charAt(0) == 'u' || currentWord.charAt(0) == 'A' || currentWord.charAt(0) == 'E' || currentWord.charAt(0) == 'I' || currentWord.charAt(0) == 'O' || currentWord.charAt(0) == 'U') {
                sb.append("ma");
                for (int j=0; j<i; j++) {
                    sb.append("a");
                }
                sb.append("a");
                myList.add(sb.toString());
                sb.setLength(0);
            }
            else {
                char firstChar = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(firstChar);
                sb.append("ma");
                for (int j=0; j<i; j++) {
                    sb.append("a");
                }
                sb.append("a");
                myList.add(sb.toString());
                sb.setLength(0);
            }
        }
        String output  = myList.get(0);
        for (int i=1; i< myList.size(); i++) {
            output+= " " +myList.get(i);
        }
        return output;
    }
}