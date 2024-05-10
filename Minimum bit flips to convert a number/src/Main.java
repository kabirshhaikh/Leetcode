public class Main {
    public static void main (String[] args) {
        int start = 10;
        int goal = 7;
        int test = minBitFlips(start, goal);
        System.out.println(test);
    }



    public static int minBitFlips (int start, int goal) {
        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);
        int output = 0;

        int maxLength = Math.max(s.length(), g.length());
        s = String.format("%" + maxLength + "s", s).replace(' ', '0');
        g = String.format("%" + maxLength + "s", g).replace(' ', '0');

        StringBuilder startSb = new StringBuilder(s);
        StringBuilder goalSb = new StringBuilder(g);

        for (int i=0; i<startSb.length() && i<goalSb.length(); i++) {
            char startChar = startSb.charAt(i);
            char goalChar = goalSb.charAt(i);
            if (startChar != goalChar) {
                startSb.setCharAt(i, goalChar);
                output = output + 1;
            }
        }

        return output;
    }



}