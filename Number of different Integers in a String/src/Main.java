import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String word = "a123bc34d8ef34";
        int test = numDifferentIntegers(word);
        System.out.println(test);
    }

    public static int numDifferentIntegers(String word) {
        HashSet<String> uniqueNumbers = new HashSet<>();
        String cleanedWord = word.replaceAll("[^0-9]+", " ");
        String[] numbers = cleanedWord.trim().split(" ");
        for (String number : numbers) {
            if (!number.isEmpty()) {
                String cleanedNumber = number.replaceFirst("^0+", "");
                uniqueNumbers.add(cleanedNumber);
            }
        }

        return uniqueNumbers.size();
    }
}
