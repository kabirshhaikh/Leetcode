public class Main {
    public static void main (String[] args) {
        int n = 7;
        int test = numebrOfMatches(n);
        System.out.println(test);
    }


    public static int numebrOfMatches (int n) {
        int numberOfMatches = 0;
        while (n > 1) {
            if (n % 2 == 1) {
                numberOfMatches += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            } else {
                numberOfMatches += n / 2;
                n = n / 2;
            }
        }
        return numberOfMatches;
    }
}

