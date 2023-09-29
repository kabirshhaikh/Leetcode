public class Main {
    public static void main (String[] args) {
        int num = 38;
        int test = addDigits(num);
        System.out.println(test);
    }

    public static int addDigits (int num) {
        while (num >= 10) {
            int sum = 0;
            String numStr = String.valueOf(num);
            for (int i = 0; i < numStr.length(); i++) {
                sum += numStr.charAt(i) - '0';
            }
            num = sum;
        }
        return num;
    }
}
