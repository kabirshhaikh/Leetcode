import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        String s = "xyzzaz";
        int test = countGoodSubstrings(s);
        System.out.println(test);
    }


    public static int countGoodSubstrings (String s) {
        int k = 3;
        int n = s.length();

        if (n < k) {
            System.out.println("Length of array cannot be less than size of window");
            return 0;
        }

        HashSet<Character> set = new HashSet<>();

        // Initial compute of first window
        for (int i = 0; i < k; i++) {
            set.add(s.charAt(i));
        }

        int goodString = 0;

        if (set.size() == 3) {
            goodString++;
        }

        // Slide window
        for (int i = 1; i <= n - k; i++) {
            set.clear();
            set.add(s.charAt(i));
            set.add(s.charAt(i + 1));
            set.add(s.charAt(i + 2));

            if (set.size() == 3) {
                goodString++;
            }
        }

        return goodString;
    }
}
