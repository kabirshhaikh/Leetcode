import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        String s = "abcabc";
        int test = numberOfSubstrings(s);
        System.out.println(test);
    }



    private static int numberOfSubstrings (String s) {
        int output = 0;

        HashMap<Character, Integer> myMap = new HashMap<>();
        int left = 0;

        for (int right=0; right<s.length(); right++) {
            char current = s.charAt(right);
            myMap.put(current, myMap.getOrDefault(current, 0) + 1);

            while (myMap.size() == 3) {
                output += s.length() - right;
                char leftChar = s.charAt(left);
                int count = myMap.get(leftChar);

                if (count == 1) {
                    myMap.remove(leftChar);
                }
                else {
                    myMap.put(leftChar, count - 1);
                }
                left++;
            }
        }


        return output;
    }
}
