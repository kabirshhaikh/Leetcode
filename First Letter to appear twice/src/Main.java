import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String s = "eesll";
        repeatedCharacter(s);
    }

    public static char repeatedCharacter (String s) {
        HashSet<Character> myset = new HashSet<>();
        char[] myArray = new char[1];
        for (int i=0; i<s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (!myset.contains(currentCharacter)) {
                myset.add(currentCharacter);
            }
            else {
                myArray[0] = currentCharacter;
                break;
            }
        }
        char ch = myArray[0];
        System.out.println("Repeated character:" + ch);
        return ch;
    }
}