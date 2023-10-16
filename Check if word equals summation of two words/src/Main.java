public class Main {
    public static void main (String[] args) {
        String firstWord = "acb";
        String secondWord = "cba";
        String targetWord = "cdb";
        boolean test = isSumEqual(firstWord, secondWord, targetWord);
        System.out.println(test);
    }

    public static boolean isSumEqual (String firstWord, String secondWord, String targetWord) {
        int firstValue = calculateValue(firstWord);
        int secondValue = calculateValue(secondWord);
        int targetValue = calculateValue(targetWord);
        if (firstValue + secondValue == targetValue) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int calculateValue (String word) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            sb.append(currentChar - 'a');
        }
        return Integer.parseInt(sb.toString());
    }
}
