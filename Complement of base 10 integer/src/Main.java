public class Main {
    public static void main (String[] args) {
        int n = 5;
        int test = bitwiseComplement(n);
        System.out.println(test);
    }



    public static int bitwiseComplement (int n) {
        String num = Integer.toBinaryString(n);
        StringBuilder number = new StringBuilder(num);

        for (int i=0; i<number.length(); i++) {
            char currentChar = number.charAt(i);
            if (currentChar == '0') {
                number.setCharAt(i, '1');
            }
            else {
                number.setCharAt(i, '0');
            }
        }

        int output = Integer.parseInt(number.toString(), 2);

        return output;
    }
}