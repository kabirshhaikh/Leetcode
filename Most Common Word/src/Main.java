import java.util.*;

public class Main {
    public static void main (String[] args) {
        String[] banned = {"a"};
        String paragraph = "a, a, a, a, b,b,b,c, c";
        mostCommonWord(paragraph, banned);
    }


    public static String mostCommonWord (String paragraph, String[] banned) {
        String[] para = paragraph.replaceAll("[!?',;.]+", "").toLowerCase().split("\\s+");
        for (int i=0; i<para.length; i++) {
            para[i] = para[i].toLowerCase();
        }
        if (banned.length == 0) {
            return para[0];
        }
        System.out.println(Arrays.toString(para));
        Set<String> mySet = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> myMap = new HashMap<>();
//        myMap.clear();
        for (int i=0; i<para.length; i++) {
            String currentWord = para[i];
            if (!mySet.contains(currentWord)) {
                int count = myMap.getOrDefault(currentWord, 0) + 1;
                myMap.put(currentWord, count);
            }
        }
        String output = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value > maxCount) {
                output = key;
                maxCount = value;
            }
        }
        System.out.println(output + " : " +maxCount);
        return output;
    }

}