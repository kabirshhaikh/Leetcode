public class Main {
    public static void main (String[] ars) {
        int n = 8;
        int test = arrangeCoins(n);
        System.out.println(test);
    }


    public static int arrangeCoins (int n) {
        if (n == 1) {
            return 1;
        }

        int completeRows = 0;

        for (int i=1; i<=n; i++) {
           n = n - i;
           if (n < 0) {
               break;
           }
           else {
               completeRows++;
           }
        }


        return completeRows;
    }
}
