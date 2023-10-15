public class Main {
    public static void main (String[] args) {
        String licensePlate = "";
        String[] words = {"step","steps","stripe","stepple"};
        String test = shortestCompletingWord(licensePlate, words);
        System.out.println(test);
    }

    public static String shortestCompletingWord (String licensePlate, String[] words) {
        String shortestCompletedWord = null;
        int[] licenseFreq = getFrequency(licensePlate);
        int shortestLength = Integer.MAX_VALUE;

        for (int i=0; i<words.length; i++) {
            String currentWord = words[i];
            int[] currentWordArray = getFrequency(currentWord);
            if (containsCharacters(currentWordArray, licenseFreq) && currentWord.length() < shortestLength) {
                shortestCompletedWord = currentWord;
                shortestLength = currentWord.length();
            }
        }

        return shortestCompletedWord;
    }

    public static int[] getFrequency (String s) {
        int[] freq = new int[26];
        char[] charArray = s.toLowerCase().toCharArray();
        for (int i=0; i< charArray.length; i++) {
            char currentChar = charArray[i];
            if (Character.isLetter(currentChar)) {
                int index = currentChar - 'a';
                freq[index]++;
            }
        }
        return freq;
    }

    public static boolean containsCharacters (int[] wordFreq, int[] licenseFreq) {
        for (int i=0; i<26; i++) {
            if (licenseFreq[i] > 0 && wordFreq[i] < licenseFreq[i]) {
                return false;
            }
        }
        return true;
    }


}