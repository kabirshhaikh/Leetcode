import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String s = "aaabc";
        int test = minimizedStringLength(s);
        System.out.println(test);
    }

    public static int minimizedStringLength (String s) {
        HashSet<Character> mySet = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            mySet.add(currentChar);
        }
        return mySet.size();
    }
}