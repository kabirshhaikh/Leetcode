import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one.two.three");
        list.add("four.five");
        list.add("six");
        char separator = '.';
        splitWordsBySeparator(list, separator);
    }

    public static List<String> splitWordsBySeparator (List<String> words, char separator) {
        List<String> myList = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            StringBuilder sb = new StringBuilder();

            for (int pointer = 0; pointer < currentWord.length(); pointer++) {
                char currentChar = currentWord.charAt(pointer);
                if (currentChar != separator) {
                    sb.append(currentChar);
                } else {
                    if (sb.length() > 0) {
                        myList.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            }
            if (sb.length() > 0) {
                myList.add(sb.toString());
            }
        }
        return myList;
    }
}