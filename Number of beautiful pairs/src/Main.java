public class Main {
    public static void main (String[] args) {
        int[] nums = {11,21,12};
        int test = countBeautifulPairs(nums);
        System.out.println(test);
    }

    public static int countBeautifulPairs (int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int firstDigit = nums[i];
            while (firstDigit > 9) firstDigit /= 10;
            for (int j = i + 1; j < nums.length; j++) {
                int lastDigit = nums[j] % 10;
                if (gcd(firstDigit, lastDigit) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}