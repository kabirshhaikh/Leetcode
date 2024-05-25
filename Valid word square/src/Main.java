import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("abcd");
        words.add("bnrt");
        words.add("crmy");
        words.add("dtye");
        boolean test = validWordSquare(words);
        System.out.println(test);
    }

    public static boolean validWordSquare(List<String> words) {
        for (int wordNum = 0; wordNum < words.size(); ++wordNum) {
            for (int charPos = 0; charPos < words.get(wordNum).length(); ++charPos) {
                if (charPos >= words.size() ||
                        wordNum >= words.get(charPos).length() ||
                        words.get(wordNum).charAt(charPos) != words.get(charPos).charAt(wordNum)) {
                    return false;
                }
            }
        }
        return true;
    }
}
