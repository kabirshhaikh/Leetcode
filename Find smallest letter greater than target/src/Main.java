public class Main {
    public static void main (String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'd';
        char test = nextGreatestLetter(letters, target);
        System.out.println(test);
    }


    public static char nextGreatestLetter (char[] letters, char target)  {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

}
