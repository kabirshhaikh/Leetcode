import java.util.ArrayList;

public class Main {
    public static void main (String[] test) {
        String title = "First leTTeR of EACH Word";
        String t = capitalizeTile(title);
        System.out.println(t);
    }

    public static String capitalizeTile (String title) {
        String[] t = title.split(" ");
        ArrayList<String> myList = new ArrayList<>();
        for (int i=0; i<t.length; i++) {
            String currentWord = t[i];
            if(currentWord.length() > 2) {
                StringBuilder sb = new StringBuilder();
                String newWord = currentWord.toLowerCase();
                char c = Character.toUpperCase(currentWord.charAt(0));
                sb.append(c).append(newWord.substring(1, newWord.length()));
                String output = sb.toString();
                myList.add(output);
            }
            else if (currentWord.length() <= 2) {
                String newWord = currentWord.toLowerCase();
                myList.add(newWord);
            }
        }
        String finalResult = String.join(" ", myList);
        return finalResult;
    }

}
