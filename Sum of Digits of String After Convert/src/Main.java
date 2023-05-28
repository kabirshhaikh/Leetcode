import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String s = "leetcode";
        int k = 2;
        getLucky(s, k);
    }


    public static int getLucky (String s, int k) {
        int[] numberValueOfCharacters = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            char currentCharacter = s.charAt(i);
            numberValueOfCharacters[i] = currentCharacter - 'a' + 1;
        }
        StringBuilder transform1 = new StringBuilder();
        for (int i =0; i<numberValueOfCharacters.length; i++) {
            transform1.append(numberValueOfCharacters[i]);
        }
        String transformed1 = transform1.toString();
        int finalOutput = 0;
        for (int i=0; i<k; i++) {
            finalOutput = 0;
            for (int j=0; j<transformed1.length(); j++) {
                char currentCharacter = transformed1.charAt(j);
                finalOutput += Integer.parseInt(String.valueOf(currentCharacter));
            }
            transformed1 = String.valueOf(finalOutput);
        }
        System.out.println("Final Output:" +finalOutput);
        return finalOutput;
    }

}