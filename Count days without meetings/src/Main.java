import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        int test = countDays(days, meetings);
        System.out.println(test);
    }

    //[  [1,3],   [2,4]] => []
    private static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = meetings[0];

        for (int i = 1; i < meetings.length; i++) {
            int[] next = meetings[i];
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);

        int meetingDays = 0;
        for (int i = 0; i < merged.size(); i++) {
            int[] mergedArray = merged.get(i);

            meetingDays = meetingDays + (mergedArray[1] - mergedArray[0] + 1);
        }


        return days - meetingDays;
    }
}
