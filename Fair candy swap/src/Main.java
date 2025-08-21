import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] aliceSizes = {1, 1};
        int[] bobSizes = {2, 2};
        int[] test = fairCandySwap(aliceSizes, bobSizes);
        System.out.println(Arrays.toString(test));
    }


    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] answer = new int[2];

        int aliceSum = getSum(aliceSizes);
        int bobSum = getSum(bobSizes);
        int difference = (aliceSum - bobSum) / 2;
        HashSet<Integer> bobSet = getSet(bobSizes);

        for (int i = 0; i < aliceSizes.length; i++) {
            int toCheckInBobSet = aliceSizes[i] - difference;
            if (bobSet.contains(toCheckInBobSet)) {
                answer[0] = aliceSizes[i];
                answer[1] = toCheckInBobSet;
                break;
            }
        }

        return answer;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static HashSet<Integer> getSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        return set;
    }
}
