import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "abacbc";
        areOccurrencesEqual(s);
    }
    public static boolean areOccurrencesEqual (String s) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        for (int i=0 ; i<s.length(); i++) {
            char currentCharacter = s.charAt(i);
            myMap.put(currentCharacter, myMap.getOrDefault(currentCharacter, 0) +1);
        }
        int firstOccurrece = -1;
        for (Map.Entry<Character, Integer> entry : myMap.entrySet()) {
            int value = entry.getValue();
            if (firstOccurrece == -1) {
                firstOccurrece = value;
            }
            else if (value != firstOccurrece) {
                return false;
            }
        }
        return true;
    }
}