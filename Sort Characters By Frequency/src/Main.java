import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {
        String s = "tree";
        frequencySort(s);
    }

    public static String frequencySort (String s) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            myMap.put(currentChar, myMap.getOrDefault(currentChar, 0) + 1);
        }
       String sortedString = myMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).flatMap(entry -> {
           char key = entry.getKey();
           int value = entry.getValue();
           return String.valueOf(key).repeat(value).chars().mapToObj(c -> String.valueOf((char) c));
       }).collect(Collectors.joining());
        System.out.println("Sorted String:" + sortedString);
        return sortedString;
    }
}