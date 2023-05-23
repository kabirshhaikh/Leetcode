public class Main {
    public static void main (String[] args) {
        char ch = 'd';
        String word = "abcdefd";
        reversePrefix(word, ch);
    }

    public static String reversePrefix (String word, char ch) {
        boolean isPresent = false;
        String reveredString = "";
        String empty = "";
        int i=0;
        while (i<word.length()) {
            char currentCharacter = word.charAt(i);
            if (currentCharacter != ch) {
                reveredString += currentCharacter;
                i++;
            }
            if (currentCharacter == ch) {
                reveredString += currentCharacter;
                break;
            }
        }
        String reverse = "";
        for (int j=reveredString.length()-1; j>=0; j--) {
            char currentCharacter = reveredString.charAt(j);
            reverse += currentCharacter;
        }
        for (int j=0; j<word.length(); j++) {
            char currentCharacter = word.charAt(j);
            if (isPresent) {
                empty += currentCharacter;
            }
            if (currentCharacter == ch) {
                isPresent = true;
            }
        }
        String finalString = reverse + empty;
        System.out.println("Final String:" +finalString);
        if (isPresent) {
            return finalString;
        }
        else {
            return word;
        }
    }
}