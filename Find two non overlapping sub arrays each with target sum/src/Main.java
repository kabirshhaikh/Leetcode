import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {7,3,4,7};
        int target = 7;
        int test = minSumOfLengths(arr, target);
        System.out.println(test);
    }

    public static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] leftMin = new int[n];
        Arrays.fill(leftMin, Integer.MAX_VALUE);

        int left = 0;
        int windowSum = 0;
        int minLen = Integer.MAX_VALUE;

        // Left to right sliding window
        for (int right = 0; right < n; right++) {
            windowSum += arr[right];

            while (windowSum > target) {
                windowSum -= arr[left];
                left++;
            }

            if (windowSum == target) {
                int currLen = right - left + 1;
                minLen = Math.min(minLen, currLen);
                leftMin[right] = minLen;
            } else {
                if (right > 0) {
                    leftMin[right] = leftMin[right - 1];
                }
            }
        }

        // Right to left sliding window
        int res = Integer.MAX_VALUE;
        left = n - 1;
        windowSum = 0;
        minLen = Integer.MAX_VALUE;

        for (int right = n - 1; right >= 0; right--) {
            windowSum += arr[right];

            while (windowSum > target) {
                windowSum -= arr[left];
                left--;
            }

            if (windowSum == target) {
                int currLen = left - right + 1;
                if (right > 0 && leftMin[right - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, currLen + leftMin[right - 1]);
                }
                minLen = Math.min(minLen, currLen);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
