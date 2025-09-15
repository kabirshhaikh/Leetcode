import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "aeiaeia";
        int test = maxFreqSum(s);
        System.out.println(test);
    }


    public static int maxFreqSum(String s) {
        int maxVowel = 0;
        int maxConsonant = 0;

        HashSet<Character> vowels = getVowels();
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> map : freq.entrySet()) {
            char key = map.getKey();
            int count = map.getValue();

            if (vowels.contains(key)) {
                maxVowel = Math.max(maxVowel, count);
            } else {
                maxConsonant = Math.max(maxConsonant, count);
            }
        }

        return maxVowel + maxConsonant;
    }


    public static HashSet<Character> getVowels() {
        HashSet<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        return vowels;
    }
}
