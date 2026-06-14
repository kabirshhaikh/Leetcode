import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] interval = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] test = insert(interval, newInterval);
        System.out.println(Arrays.deepToString(test));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int[] nInterval = newInterval;
        boolean nIntervalInserted = false;

        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int existingStart = curr[0];
            int existingEnd = curr[1];

            int newStart = nInterval[0];
            int newEnd = nInterval[1];

            if (existingStart < newStart && existingEnd < newStart) {
                int[] temp = new int[2];
                temp[0] = existingStart;
                temp[1] = existingEnd;
                list.add(temp);
            } else if (existingStart <= newEnd && existingEnd >= newStart) {//overlap
                nInterval[0] = Math.min(nInterval[0], existingStart);
                nInterval[1] = Math.max(nInterval[1], existingEnd);
            } else {
                //if existingEnd starts after newInterval end then add newInterval firt then the exisitng start and end:
                list.add(nInterval);
                nIntervalInserted = true;
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }

                break;
            }
        }

        if (!nIntervalInserted) {
            list.add(nInterval);
        }

        return list.toArray(new int[list.size()][]);
    }
}
