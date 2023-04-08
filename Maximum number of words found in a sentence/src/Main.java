import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(sentences));
    }

    public static int mostWordsFound (String[] sentences) {
        int maxWordCount = 0;
        for (int i=0; i<sentences.length; i++) {
            String tempWord = sentences[i].toString();
            int count = 0;
            for (int j=0; j<tempWord.length(); j++) {
                if (tempWord.charAt(j) == ' ') {
                    count = count + 1;
                }
            }
            if (count > maxWordCount) {
                maxWordCount = count;
            }
        }
        return  maxWordCount + 1;
    }
}