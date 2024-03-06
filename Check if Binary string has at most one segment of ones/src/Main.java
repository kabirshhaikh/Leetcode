public class Main {
    public static void main (String[] args) {
        String s = "110";
        boolean test = checkOnesSegment(s);
        System.out.println(test);
    }



    public static boolean checkOnesSegment (String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                segmentCount++;
                while (i < s.length() - 1 && s.charAt(i + 1) == '1') {
                    i++;
                }
            }
        }
        return segmentCount <= 1;
    }
}
