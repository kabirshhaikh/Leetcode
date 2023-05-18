public class Main {
    public static void main (String[] args) {
        String s = "aababcabc";
        countGoodSubStrings(s);
    }

    public static int countGoodSubStrings (String s) {
        int count = 0;
        for (int i=0; i<s.length()-2; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            char ch3 = s.charAt(i+2);
            if (ch1 != ch2 && ch2!= ch3 && ch1!= ch3) {
                count = count + 1;
            }

        }
        System.out.println("Count:" + count);
        return count;
    }
}
