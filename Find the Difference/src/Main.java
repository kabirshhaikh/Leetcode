import java.util.HashMap;
public class Main {
    public static void main (String[] args) {
        String s = "abcd";
        String t = "abcde";
        char ch  = findTheDifference(s, t);
        System.out.println(ch);
    }

    public static char findTheDifference (String s, String t) {
        HashMap<Character, Integer> myMap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            myMap.put(ch, myMap.getOrDefault(ch, 0) + 1);
        }
        for (int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            int count = myMap.getOrDefault(ch, 0);
            if (count == 0) {
                return ch;
            }
            myMap.put(ch, count -1);
        }
        throw new IllegalArgumentException("No difference found between the strings.");
    }

}
