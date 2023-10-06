import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String text = "nlaebolko";
        int test = maxNumberOfBalloons(text);
        System.out.println(test);
    }

    public static int maxNumberOfBalloons (String text) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        for (int i=0; i<text.length(); i++) {
            char currentChar = text.charAt(i);
            myMap.put(currentChar, myMap.getOrDefault(currentChar, 0) + 1);
        }
        for (Map.Entry<Character, Integer> map : myMap.entrySet()) {
            char character = map.getKey();
            int value = map.getValue();
        }
        int b = 1, a = 1, l = 2, o = 2, n = 1;
        a = myMap.getOrDefault('a', 0);
        b = myMap.getOrDefault('b', 0);
        l = myMap.getOrDefault('l', 0) / 2;
        o = myMap.getOrDefault('o', 0) / 2;
        n = myMap.getOrDefault('n', 0);
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }

}