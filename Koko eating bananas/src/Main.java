public class Main {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int test = minEatingSpeed(piles, h);
        System.out.println(test);
    }


    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = highestNumber(piles);

        while (low < high) {
            int mid = (low + high) / 2;
            if (canFinish(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean canFinish(int[] piles, int mid, int h) {
        int totalHours = 0;

        for (int i = 0; i < piles.length; i++) {
            totalHours += (piles[i] + mid - 1) / mid;
            if (totalHours > h) {
                return false;
            }
        }

        return totalHours <= h;
    }


    public static int highestNumber(int[] piles) {
        if (piles.length == 0) return -1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > high) {
                high = piles[i];
            }
        }
        return high;
    }
}
