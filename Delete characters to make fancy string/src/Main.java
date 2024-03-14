public class Main {
    public static void main (String[] args) {
        String s = "aaabaaaa";
        String test = makeFancyString(s);
        System.out.println(test);
    }


    public static String makeFancyString (String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 2) {
            if (sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i) == sb.charAt(i + 2)) {
                sb.deleteCharAt(i + 2);
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}