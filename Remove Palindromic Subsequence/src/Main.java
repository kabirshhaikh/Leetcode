public class Main {
    public static void main (String[] args) {
        String s = "ababa";
        int test = removePlaindromicSub(s);
        System.out.println(test);
    }

    public static int removePlaindromicSub (String s) {
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reversedString = sb.toString();
        if (reversedString.equals(s)) {
            return 1;
        }
        return 2;
    }
}