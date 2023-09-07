import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "lEeTcOdE";
        String test = greatestLetter(s);
        System.out.println(test);
    }

    public static String greatestLetter (String s) {
        HashMap<Character, Integer> upperCaseMap = new HashMap<>();
        HashMap<Character, Integer> lowerCaseMap = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                upperCaseMap.put(currentChar, upperCaseMap.getOrDefault(currentChar, 0) + 1);
            }
            else if (Character.isLowerCase(currentChar)) {
                lowerCaseMap.put(currentChar, lowerCaseMap.getOrDefault(currentChar, 0) + 1);
            }
        }

        char greatestCommonLetter = 0;

        for(Map.Entry<Character, Integer> map : upperCaseMap.entrySet()) {
           char upperCaseCharacter = map.getKey();
           char lowerCaseCharacter = Character.toLowerCase(upperCaseCharacter);
           if (lowerCaseMap.containsKey(lowerCaseCharacter)) {
               if (upperCaseCharacter > greatestCommonLetter ) {
                   greatestCommonLetter = upperCaseCharacter;
               }
           }
        }

        if (greatestCommonLetter != 0) {
            return Character.toString(greatestCommonLetter);
        }
        else {
            return "";
        }

    }
}