public class Main {
    public static void main (String[] args) {
        int n = 11;
        boolean test = hasAlternatingBits(n);
        System.out.println(test);
    }



    public static boolean hasAlternatingBits (int n) {
        String number = Integer.toBinaryString(n);

        for (int i=0; i<number.length()-1; i++) {
            char currentChar = number.charAt(i);
            char nextChar = number.charAt(i+1);
            if (currentChar == nextChar) {
                return false;
            }
        }

        return true;
    }
}