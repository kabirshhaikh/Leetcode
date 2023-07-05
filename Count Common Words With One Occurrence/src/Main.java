import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String[] words1 = {"leetcode","is","amazing","as","is"};
        String[] words2 = {"amazing","leetcode","is"};
        countWords(words1, words2);
    }

    public static int countWords (String[] words1, String[] words2) {
        Map<String, Integer> countMap1 = new HashMap<>();
        Map<String, Integer> countMap2 = new HashMap<>();
        for (String wordOne : words1) {
            countMap1.put(wordOne, countMap1.getOrDefault(wordOne, 0) + 1);
        }
        for (String wordTwo:words2) {
            countMap2.put(wordTwo, countMap2.getOrDefault(wordTwo, 0) + 1);
        }
        int finalCount = 0;
        for (String word : words1) {
            if (countMap1.get(word) == 1 && countMap2.getOrDefault(word, 0) == 1) {
                finalCount++;
            }
        }
        System.out.println(finalCount);
        return finalCount;
    }

}
