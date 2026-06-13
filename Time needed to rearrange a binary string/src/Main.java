public class Main {
    public static void main(String[] args) {
        String s = "0110101";
        int test = secondsToRemoveOccurrences(s);
        System.out.println(test);
    }

    public static int secondsToRemoveOccurrences(String s) {
        int zero = 0;
        int second = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else if (zero > 0) {
                second = Math.max(second + 1, zero);
            }
        }

        return second;
    }
}
