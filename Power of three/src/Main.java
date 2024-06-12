public class Main {
    public static void main (String[] args) {
        int n = 45;
        boolean test = isPowerOfThree(n);
        System.out.println(test);
    }


    public static boolean isPowerOfThree (int n) {
        if (n <= 0) {
            return false;
        }

        int result = 1;

       for (int i=0; i<20; i++) {
           if (result == n) {
               return true;
           }
           if (result > n/3) {
               break;
           }
           result = result * 3;
       }

       return false;
    }
}
