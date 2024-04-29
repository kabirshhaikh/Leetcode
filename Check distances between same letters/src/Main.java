import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String s = "abaccb";
        int[] distances = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        boolean test = checkDistances(s, distances);
        System.out.println(test);
    }

    public static boolean checkDistances (String s, int[] distance) {
        HashSet<Character> mySet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (mySet.contains(currentChar)) {
                continue;
            } else {
                mySet.add(currentChar);
                int indexOfCurrentChar = i;
                int indexOfNextChar = 0;
                int countOfCharacters = 0;
                for (int right = i + 1; right < s.length(); right++) {
                    char nextChar = s.charAt(right);
                    if (nextChar == currentChar) {
                        indexOfNextChar = right;
                        break;
                    }
                }
                if (indexOfNextChar != 0) {
                    for (int j = indexOfCurrentChar + 1; j < indexOfNextChar; j++) {
                        countOfCharacters = countOfCharacters + 1;
                    }
                }
                if (countOfCharacters != distance[currentChar - 'a']) {
                    return false;
                }
            }
        }
        return true;
    }


}