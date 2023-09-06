public class Main {
    public static void main (String[] args) {
        String s = "foobar";
        char letter = 'o';
        int test = percentageLetter(s, letter);
        System.out.println(test + "%");
    }

    public static int percentageLetter (String s, char letter) {
        int occurrenceOfLetter = 0;
        int lengthOfString = s.length();
        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == letter) {
                occurrenceOfLetter = occurrenceOfLetter + 1;
            }
        }
        double percentage = ((double) occurrenceOfLetter/lengthOfString) * 100;
        int roundedPercentage = (int) Math.floor(percentage);
        return roundedPercentage;
    }
}