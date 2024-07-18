import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        String s = "bcbbbcba";
        int test = maximumLengthSubstring(s);
        System.out.println(test);
    }


    public static int maximumLengthSubstring (String s) {
        int length = 0;
        for (int i=0; i<s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j=i; j<s.length(); j++) {
                char currentChar = s.charAt(j);
                map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
                if (map.containsKey(s.charAt(j))) {
                    int value = map.get(s.charAt(j));
                    if (value > 2) {
                        break;
                    }
                }
                length = Math.max(length, j - i + 1);
            }
        }
        return length;
    }

}
