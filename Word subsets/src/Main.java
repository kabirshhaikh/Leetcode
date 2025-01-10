import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"l", "e"};
        List<String> test = wordSubsets(words1, words2);
        System.out.println(test);
    }


    public static List<String> wordSubsets (String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        //Frequency map for words2:
        HashMap<Character, Integer> word2Map = new HashMap<>();

        for (int i=0; i<words2.length; i++) {
            String currentWord = words2[i];
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (int j=0; j<currentWord.length(); j++) {
                char character = currentWord.charAt(j);
                tempMap.put(character, tempMap.getOrDefault(character, 0) + 1);
            }

            //Merging tempMap to word2Map -> if word2Map does not have a character from tempMap then add otherwise update the count:
            for (Map.Entry<Character, Integer> map : tempMap.entrySet()) {
                char key = map.getKey();
                int count = map.getValue();

                word2Map.put(key, Math.max(word2Map.getOrDefault(key, 0), count));
            }
        }

        for (int i=0; i<words1.length; i++) {
            String currentWord = words1[i];
            HashMap<Character, Integer> tempMap = new HashMap<>();
            boolean isPresent = true;
            //Add character count of currentWord to tempMap:
            for (int j=0; j<currentWord.length(); j++) {
                char character = currentWord.charAt(j);
                tempMap.put(character, tempMap.getOrDefault(character, 0) + 1);
            }

            //Check if characters from word2Map exists with at least given freq in tempMap for currentWord:
            for (Map.Entry<Character, Integer> map : word2Map.entrySet()) {
                char key = map.getKey();
                int count = map.getValue();
                if (tempMap.getOrDefault(key, 0) < count) {
                    isPresent = false;
                    break;
                }
            }

            if (isPresent) {
                list.add(currentWord);
            }

        }

        return list;
    }
}
