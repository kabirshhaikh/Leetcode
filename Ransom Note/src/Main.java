import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean test = canConstruct(ransomNote, magazine);
        System.out.println(test);
    }

    public static boolean canConstruct (String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomNoteMap = new HashMap<>();
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for (int i=0; i<ransomNote.length(); i++) {
            char currentChar = ransomNote.charAt(i);
            ransomNoteMap.put(currentChar, ransomNoteMap.getOrDefault(currentChar, 0) + 1);
        }
        for (int i=0; i<magazine.length(); i++) {
            char currentChar = magazine.charAt(i);
            magazineMap.put(currentChar, magazineMap.getOrDefault(currentChar, 0) + 1);
        }
        for (Map.Entry<Character, Integer> map : ransomNoteMap.entrySet()) {
            char key = map.getKey();
            int count = map.getValue();
            if (magazineMap.containsKey(key)) {
                int magazineCount = magazineMap.get(key);
                if (count <= magazineCount ) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}