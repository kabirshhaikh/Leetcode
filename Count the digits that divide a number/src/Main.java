public class Main {
    public static void main (String[] args) {
        int num = 1248;
        int test = countDigits(num);
        System.out.println(test);
    }


    public static int countDigits (int num) {
        String number = String.valueOf(num);
        int output = 0;

        for (int i=0; i<number.length(); i++) {
            char currentChar = number.charAt(i);
            int numberToBeDivided = num;
            int divider = currentChar - '0';
            if (numberToBeDivided % divider == 0) {
                output = output + 1;
            }
        }

        return output;
    }
}