public class Main {
    public static void main (String[] args) {
        int left = 6;
        int right = 10;
        int test = countPrimeSetBits(left, right);
        System.out.println(test);
    }



    public static int countPrimeSetBits (int left, int right) {
        int output = 0;

        for (int i=left; i <=right; i++) {
            int numberOfOnes = 0;
            String number = Integer.toBinaryString(i);
            for (int j=0; j<number.length(); j++) {
                if (number.charAt(j) == '1') {
                    numberOfOnes = numberOfOnes + 1;
                }
            }
            boolean prime = isPrime(numberOfOnes);
            if (prime) {
                output = output + 1;
            }
        }

        return output;
    }


    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}