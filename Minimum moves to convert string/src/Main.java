public class Main {
    public static void main (String[] args) {
        String s = "XXOX";
        int test = minimumMoves(s);
        System.out.println(test);
    }



    public static int minimumMoves (String s) {
        int count = 0;

        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == 'X') {
                count++;
                i += 3;
            } else {
                i++;
            }
        }

        return count;
    }
}