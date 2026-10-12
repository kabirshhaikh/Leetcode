public class Main {
    public static void main(String[] args) {
        String[] wordArray = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance word = new WordDistance(wordArray);
        System.out.println(word.shortest("coding", "practice"));
        System.out.println(word.shortest("makes", "coding"));
    }
}
