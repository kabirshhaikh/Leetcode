public class Main {
    public static void main (String[] args) {
        int n = 12;
        boolean test = checkPowerOfThree(n);
        System.out.println(test);
    }


    private static boolean checkPowerOfThree (int n) {
        while (n > 1) {
            int remainderOfNumber = n % 3;
            if (remainderOfNumber != 0 && remainderOfNumber != 1) {
                return false;
            }
            else {
                n = n/3;
            }
        }

        return true;
    }
}
