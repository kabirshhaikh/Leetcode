public class Main {
    public static void main (String[] args) {
        int n = 234;
        subtractProductAndSum(n);
    }

    public static int subtractProductAndSum (int n) {
        int product = 1;
        int sum = 0;
        String number = Integer.toString(n);
        for (int i=0; i<number.length(); i++) {
            char currentNumber = number.charAt(i);
            product = product * Character.getNumericValue(currentNumber);
            sum += Character.getNumericValue(currentNumber);
        }
        int result = product - sum;
        return result;
    }

}