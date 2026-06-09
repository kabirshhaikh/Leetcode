import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String word = "asdf";
        int test = countDivisibleSubstrings(word);
        System.out.println(test);
    }

    public static int countDivisibleSubstrings(String word) {
        if (word.length() == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = getMap();
        int output = 0;

        for (int i = 0; i < word.length(); i++) {
            int runningSum = 0;

            for (int j = i; j < word.length(); j++) {
                char next = word.charAt(j);
                runningSum += map.get(next);
                int length = j - i + 1;
                if (runningSum % length == 0) {
                    output++;
                }
            }
        }

        return output;
    }

    public static HashMap<Character, Integer> getMap() {
        String[] s = {"ab", "cde", "fgh", "ijk", "lmn", "opq", "rst", "uvw", "xyz"};
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length; i++) {
            String curr = s[i];
            for (int j = 0; j < curr.length(); j++) {
                char ch = curr.charAt(j);
                map.put(ch, i + 1);
            }
        }

        return map;
    }
}
