public class Main {
    public static void main (String[] args) {
        int[] chalk = {5,1,5};
        int k = 22;
        int test = chalkReplacer(chalk, k);
        System.out.println(test);
    }



    public static int chalkReplacer (int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                break;
            }
        }
        // Find modulo of k with sum.
        k = k % (int) sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k = k - chalk[i];
        }
        return 0;
    }

}
