import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        List<String> test = commonChars(words);
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + ", ");
        }
    }


    private static List<String> commonChars(String[] words) {
        List<String> output = new ArrayList<>();
        HashMap<Character, Integer> myMap = new HashMap<>();
        String firstWord = words[0];

        //Count of first word:
        for (int i = 0; i < firstWord.length(); i++) {
            char currentChar = firstWord.charAt(i);
            myMap.put(currentChar, myMap.getOrDefault(currentChar, 0) + 1);
        }

        //Iterate over other words:
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            HashMap<Character, Integer> tempMap = new HashMap<>();

            //Calculate the freq of current word:
            for (int j = 0; j < currentWord.length(); j++) {
                char currentChar = currentWord.charAt(j);
                tempMap.put(currentChar, tempMap.getOrDefault(currentChar, 0) + 1);
            }

            //Remove keys not in tempMap:
            myMap.keySet().retainAll(tempMap.keySet());

            //Update the myMap with min count:
            for (char currentChar : myMap.keySet()) {
                myMap.put(currentChar, Math.min(myMap.get(currentChar), tempMap.get(currentChar)));
            }
        }

        for (Map.Entry<Character, Integer> map : myMap.entrySet()) {
            char key = map.getKey();
            int count = map.getValue();
            for (int i=0; i<count; i++) {
                output.add(String.valueOf(key));
            }
        }

        return output;
    }
}
