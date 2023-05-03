import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String s = "aeiou";
        removeVowels(s);
    }

    public static String removeVowels (String s) {
        ArrayList<Character> myList = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                myList.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : myList) {
            sb.append(c);
        }
        String output = sb.toString();
        System.out.println("Output:" + output);
        return output;
    }

}
