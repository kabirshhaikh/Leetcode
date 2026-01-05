import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> test = findAnagrams(s, p);
        for (int i=0; i<test.size(); i++) {
            System.out.print(test.get(i) + ", ");
        }
    }

    private static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        //here i am using the canonical pattern:
        while (right < s.length()) {
            char toAdd = s.charAt(right);
            right++;

            //Add char to window:
            if (need.containsKey(toAdd)) {
                window.put(toAdd, window.getOrDefault(toAdd, 0) + 1);

                if (window.get(toAdd).equals(need.get(toAdd))) {
                    valid++;
                }
            }

            //Shrink if length of window is greater than p.length():
            while (right - left > p.length()) {
                char toRemove = s.charAt(left);
                left++;

                if (need.containsKey(toRemove)) {
                    if (need.get(toRemove).equals(window.get(toRemove))) {
                        valid--;
                    }

                    window.put(toRemove, window.get(toRemove) - 1);
                }
            }

            //Update ans if valid == need.size():
            if (right - left == p.length() && valid == need.size()) {
                output.add(left);
            }
        }

        return output;
    }
}
