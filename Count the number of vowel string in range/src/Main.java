import java.util.HashSet;

public class Main {
    public static void main (String[] agrs) {
        String[] words = {"are","amy","u"};
        int left = 0;
        int right = 2;
        int test = vowelStrings(words, left, right);
        System.out.println(test);
    }

    public static int vowelStrings (String[] words, int left, int right) {
        int count = 0;
        HashSet<Character> mySet = new HashSet<>();
        mySet.add('a');
        mySet.add('e');
        mySet.add('i');
        mySet.add('o');
        mySet.add('u');

        for (int i = left; i <= right && i < words.length; i++) {
            String currentWord = words[i];
            char firstChar = currentWord.charAt(0);
            char lastChar = currentWord.charAt(currentWord.length() - 1);

            if (mySet.contains(firstChar) && mySet.contains(lastChar)) {
                count++;
            }
        }
        return count;
    }
}