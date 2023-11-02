public class Main {
    public static void main (String[] args) {
        String s = "   fly me   to   the moon  ";
        int test = lengthOfLastWord(s);
        System.out.println(test);
    }

    public static int lengthOfLastWord (String s) {
        String sentence = s.replaceAll("\\s", " ");
        String[] words = sentence.split(" ");
        String outputWord = words[words.length -1];
        return outputWord.length();
    }
}