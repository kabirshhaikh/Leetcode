import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        checkIfPangram(sentence);
    }

    public static boolean checkIfPangram (String sentence) {
        HashSet<Character> mySet = new HashSet<>();
        for (int i=0; i<sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (!mySet.contains(ch)) {
                mySet.add(ch);
            }
        }
        if (mySet.size() != 26) {
            System.out.println("Not a pangram");
            return false;
        }
        else {
            System.out.println("Pangram");
            return true;
        }
    }

}