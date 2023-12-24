public class Main {
    public static void main (String[] args) {
        String s = "0100";
        int test = minOperations(s);
        System.out.println(test);
    }

    public static int minOperations (String s) {
        int steps = 0;

        for (int i = 0; i < s.length(); i++) {
            char targetChar = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != targetChar) {
                steps++;
            }
        }

        return Math.min(steps, s.length() - steps);
    }
}
