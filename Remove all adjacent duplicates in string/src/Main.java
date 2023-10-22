public class Main {
    public static void main (String[] args) {
        String s = "abbaca";
        String test = removeDuplicates(s);
        System.out.println(test);
    }


    public static String removeDuplicates (String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            char currentChar = sb.charAt(i);
            if (currentChar == sb.charAt(i+1)) {
                sb.delete(i, i+2);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }

}
