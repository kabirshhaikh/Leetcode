public class Main {
    public static void main (String[] args) {
        String s = "aaaabbbbcccc";
        String test = sortString(s);
        System.out.println(test);
    }



    public static String sortString (String s) {
        StringBuilder result = new StringBuilder();
        int[] count = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        while (result.length() < s.length()) {
            // Step 1 to 3: Pick smallest characters in ascending order
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    result.append((char) (i + 'a'));
                    count[i]--;
                }
            }

            // Step 4 to 6: Pick largest characters in descending order
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    result.append((char) (i + 'a'));
                    count[i]--;
                }
            }
        }

        return result.toString();
    }
}