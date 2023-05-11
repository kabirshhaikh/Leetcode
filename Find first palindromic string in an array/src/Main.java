public class Main {
    public static void main (String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        firstPalindrome(words);
    }

    public static String firstPalindrome (String[] words) {
        for (int i=0; i< words.length; i++) {
            String currentWord = words[i];
            String reversedString = "";
            for (int j=currentWord.length()-1; j>=0; j--) {
                reversedString += currentWord.charAt(j);
            }
            if (currentWord.equals(reversedString)) {
                System.out.println("Palindrome:" +currentWord);
                return currentWord;
            }
        }
        return "";
    }

}