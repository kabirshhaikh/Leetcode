public class Main {
    public static void main(String[] args) {
        int[] nums = {21, 4, 7};
        int test = sumFourDivisors(nums);
        System.out.println(test);
    }

    private static int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            boolean hasDivisors = hasFourDivisors(currentNumber);
            if (hasDivisors) {
                int sumOfCurrentNumber = getSum(currentNumber);
                sum = sum + sumOfCurrentNumber;
            }

        }

        return sum;
    }

    private static int getSum(int number) {
        int sum = 0;
        int i = 1;

        while (i * i <= number) {
            if (number % i == 0) {
                if (i == number / i) {
                    sum += i;
                } else {
                    sum += i + (number / i);
                }
            }

            i++;
        }

        return sum;
    }

    private static boolean hasFourDivisors(int number) {
        int i = 1;
        int count = 0;

        while (i * i <= number) {
            if (number % i == 0) {
                if (i == number / i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }

            i++;
        }

        if (count == 4) {
            return true;
        } else {
            return false;
        }
    }
}
