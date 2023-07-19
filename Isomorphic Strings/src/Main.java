import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String s = "egg";
        String t = "add";
        boolean test = isIsomorphic(s, t);
        System.out.println(test);
    }

    public static boolean isIsomorphic (String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> sToTMap = new HashMap<>();
        HashMap<Character, Character> tToSMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToTMap.containsKey(sChar)) {
                if (sToTMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (tToSMap.containsKey(tChar) && tToSMap.get(tChar) != sChar) {
                    return false;
                }
                sToTMap.put(sChar, tChar);
                tToSMap.put(tChar, sChar);
            }
        }

        return true;
    }

}