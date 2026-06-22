public class Main {
    public static void main(String[] args) {
        int n = 9;
        int test = guessNumber(n);
        System.out.println(test);
    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guessReturn = guess(mid);
            if (guessReturn == -1) {
                high = mid - 1;
            } else if (guessReturn == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int guess(int num) {
        int pick = 6;
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        } else {
            return 0;
        }
    }
}
