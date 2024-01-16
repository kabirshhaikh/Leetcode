import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String sequence = "a";
        String word = "a";
        int test = maxRepeating(sequence, word);
        System.out.println(test);
    }


    public static int maxRepeating (String sequence, String word) {
        ArrayList<String> myList = new ArrayList<>();

        if (sequence.length() == 1) {
            char currentChar = sequence.charAt(0);
            String currentWord = String.valueOf(currentChar);
            if (currentWord.equals(word)) {
                return 1;
            }
            else {
                return 0;
            }
        }

        for (int i=0; i<sequence.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sequence.charAt(i));
            sb.append(sequence.charAt(i+1));
            if (sb.toString().equals(word)) {
                myList.add(sb.toString());
            }
            sb.setLength(0);
        }

        int count = myList.size();

        return count;
    }
}