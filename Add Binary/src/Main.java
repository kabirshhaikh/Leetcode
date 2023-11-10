public class Main {
    public static void main (String[] args) {
        String a = "1010";
        String b = "1011";
        String test = addBinary(a, b);
        System.out.println(test);
    }

    public static String addBinary (String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int sum = carry + (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);
            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        return result.toString();
    }

}
