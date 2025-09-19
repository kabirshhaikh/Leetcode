import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "lEetcOde";
        String test = sortVowels(s);
        System.out.println(test);
    }


    public static String sortVowels(String s) {
        List<Character> sortedVowels = getVowelList(s);
        StringBuilder t = new StringBuilder(getAsteriskString(s));
        int index = 0;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '*') {
                t.setCharAt(i, sortedVowels.get(index));
                index++;
            }
        }

        return t.toString();
    }

    public static List<Character> getVowelList(String s) {
        List<Character> vowels = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowels.add(s.charAt(i));
            }
        }

        Collections.sort(vowels);
        return vowels;
    }

    public static String getAsteriskString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                sb.append("*");
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
    }
}
