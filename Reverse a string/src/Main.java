import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        char[] characters = {'h', 'e', 'l', 'l','o'};
        reverseString(characters);
    }

    public static void reverseString (char[] characters) {
        int left=0;
        int right = characters.length-1;
        System.out.println(Arrays.toString(characters));
        while (left < right)  {
            char currentCharacterAtLeft = characters[left];
            characters[left] = characters[right];
            characters[right] = currentCharacterAtLeft;
            left = left + 1;
            right  = right - 1;
        }
        System.out.println(Arrays.toString(characters));
    }




}