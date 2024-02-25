public class Main {
    public static void main (String[] args) {
        int n = 6;
        int test = smallestEvenMultiple(n);
        System.out.println(test);
    }



    public static int smallestEvenMultiple (int n) {
        int smallestNumber = Integer.MAX_VALUE;

        for (int i=1; i<Integer.MAX_VALUE; i++) {
            int currentNumber = i;
            if (currentNumber % 2 == 0 && currentNumber % n == 0) {
                if (currentNumber < smallestNumber) {
                    smallestNumber = currentNumber;
                    break;
                }
            }
        }

        return smallestNumber;
    }
}
