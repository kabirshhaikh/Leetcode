public class Main {
    public static void main (String[] args) {
        String sentence = "i love eating burger";
        String searchWord = "burg";
        isPrefixOfWord(sentence, searchWord);
    }


    public static int isPrefixOfWord (String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int output = 0;
        for (int i=0; i<words.length; i++) {
            String currentWord = words[i];
            if (currentWord.startsWith(searchWord)) {
                output = i+1;
                break;
            }
        }

        if (output == 0) {
            return -1;
        }
        else {
            return  output;
        }
    }

}