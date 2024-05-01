import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "code";
        boolean test = canPermutePalindrome(s);
        System.out.println(test);
    }


    public static boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> myMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            myMap.put(currentChar, myMap.getOrDefault(currentChar, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Character, Integer> map : myMap.entrySet()) {
            int value = map.getValue();
            count = count + value % 2;
        }

        if (count <= 1) {
            return true;
        } else {
            return false;
        }
    }
}