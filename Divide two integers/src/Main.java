public class Main {
    public static void main (String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        int test = divide (dividend, divisor);
        System.out.println(test);
    }


    public static int divide (int dividend, int divisor) {
        if(dividend==-2147483648 && divisor ==-1) return Integer.MAX_VALUE;
        int div=dividend/divisor;
        return div;
    }
}
