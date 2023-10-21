import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        String[] test = findOcurrences(text, first, second);
        System.out.println(Arrays.toString(test));
    }

    public static String[] findOcurrences (String text, String first, String second) {
        ArrayList<String> myList = new ArrayList<>();
        String[] textArray = text.split(" ");
        for (int i=0; i<textArray.length-2; i++) {
            String currentWord = textArray[i];
            if (currentWord.equals(first) && textArray[i+1].equals(second)) {
                myList.add(textArray[i+2]);
            }
        }
        String[] outputArray = new String[myList.size()];
        for (int i=0; i<myList.size(); i++) {
            outputArray[i] = myList.get(i);
        }
        return outputArray;
    }
}
