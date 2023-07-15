import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        uncommonFromSentences(s1, s2);
    }


    public static String[] uncommonFromSentences (String s1, String s2) {
        String[] word1 = s1.split(" ");
        String[] word2 = s2.split(" ");
        HashMap<String, Integer> myMap = new HashMap<>();
        ArrayList<String> myList = new ArrayList<>();
        for (int i=0; i<word1.length; i++) {
            String currentWord = word1[i];
            myMap.put(currentWord, myMap.getOrDefault(currentWord, 0) +1);
        }
        for (int i=0; i<word2.length; i++) {
            String currentWord = word2[i];
            myMap.put(currentWord, myMap.getOrDefault(currentWord, 0) +1);
        }
        for (Map.Entry<String, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            String key = map.getKey();
            if (value == 1) {
                myList.add(key);
            }
        }
        String[] output = new String[myList.size()];
        for (int i=0; i< myList.size(); i++) {
            output[i] = myList.get(i);
        }
        System.out.println(Arrays.toString(output));
        return output;
    }

}