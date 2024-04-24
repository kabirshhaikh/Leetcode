public class Main {
    public static void main (String[] args) {
        int num = 5;
        int test = findComplement(num);
        System.out.println(test);
    }

    public static int findComplement (int num) {
        String number = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<number.length(); i++) {
            if (number.charAt(i) == '1') {
                sb.append('0');
            }
            else {
                sb.append('1');
            }
        }

        int output = Integer.parseInt(sb.toString(), 2);

        return output;
    }
}
