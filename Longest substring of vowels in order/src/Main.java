public class Main {
    public static void main(String[] args) {
        String word = "aeeeiiiioooauuuaeiou";
        int test = longestBeautifulSubstring(word);
        System.out.println(test);
    }


    public static int longestBeautifulSubstring(String word) {
        int left = 0;
        int lengthOfSubString = 0;
        int vowelCount = 1;

        for (int right = 1; right < word.length(); right++) {
            char currentChar = word.charAt(right);
            char previousChar = word.charAt(right - 1);

            if (currentChar < previousChar) {
                left = right;
                vowelCount = 1;
            } else if (currentChar > previousChar) {
                vowelCount++;
            }

            if (vowelCount == 5) {
                lengthOfSubString = Math.max(lengthOfSubString, (right - left) + 1);
            }
        }

        return lengthOfSubString;
    }
}
