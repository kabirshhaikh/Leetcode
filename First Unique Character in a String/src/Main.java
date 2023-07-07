import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "leetcode";
        int test = firstUniqChar(s);
        System.out.println(test);
    }

    public static int firstUniqChar (String s) {
        LinkedHashMap<Character , Integer> myMap = new LinkedHashMap<>();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            myMap.put(currentChar, myMap.getOrDefault(currentChar, 0) + 1);
        }
        for (Map.Entry<Character, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            char key = map.getKey();
            if (value == 1) {
                return s.indexOf(key);
            }
        }
       return -1;
    }


}