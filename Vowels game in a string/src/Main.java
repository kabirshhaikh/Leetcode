import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String s = "leetcoder";
        boolean test = doesAliceWin(s);
        System.out.println(test);
    }

    public static boolean doesAliceWin(String s) {
        if (!checkIfStringContainsAtLeastOneVowel(s)) {
            return false;
        }

        return true;
    }

    public static boolean checkIfStringContainsAtLeastOneVowel(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                return true;
            }
        }

        return false;
    }
}
