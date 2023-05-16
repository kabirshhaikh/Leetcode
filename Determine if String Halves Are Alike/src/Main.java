import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String s = "book";
        halvesAreAlike(s);
    }


    public static boolean halvesAreAlike (String s) {
        //Break the string in half and store it in two arrays or arraylists:
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        String emptyStringA = "";
        for (int i = 0; i<s.length()/2; i++) {
            char ch = s.charAt(i);
            emptyStringA += ch;
        }
        a.add(emptyStringA);
        String emptyStringB = "";
        for (int i =s.length()/2; i<s.length(); i++) {
            char ch = s.charAt(i);
            emptyStringB += ch;
        }
        b.add(emptyStringB);
        //Check if the two arrays or arraylists have same number of vowels or no:
        int counterForA = 0;
        int counterForB = 0;
        for (int i=0; i<a.size() ;i++) {
            String word = a.get(i);
            for (int j=0; j<word.length(); j++) {
                char ch = word.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    counterForA = counterForA + 1;
                }
            }
        }
        for (int i=0; i<b.size(); i++) {
            String word = b.get(i);
            for (int j=0; j<word.length(); j++) {
                char ch = word.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    counterForB = counterForB + 1;
                }
            }
        }

        if (counterForA == counterForB) {
            return true;
        }
        else {
            return false;
        }


    }



}