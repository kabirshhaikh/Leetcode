import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String test = minWindow(s, t);
        System.out.println(test);
    }

    public static String minWindow (String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        //Store the freq of each element in t:
        for (int i=0; i<t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0 ) + 1);
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int matched = 0;
        int start = 0;

        for (int right=0; right<s.length(); right++) {
            char currentChar = s.charAt(right);
            sMap.put(currentChar, sMap.getOrDefault(currentChar, 0) + 1);

            if (tMap.containsKey(currentChar)  && sMap.get(currentChar).equals(tMap.get(currentChar)) ) {
                matched++;
            }

            while (matched == tMap.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);

                if (tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar) ) {
                    matched--;
                }

                left = left + 1;
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}

