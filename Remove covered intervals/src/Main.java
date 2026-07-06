import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        int test = removeCoveredIntervals(intervals);
        System.out.println(test);
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        //first sort the array:
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        //set prev:
        int[] prev = intervals[0];

        //output counter:
        int count = 1;

        //now here i start the loop at index 1:
        //since we sort by 0th index start is always sorted
        //we need to check if curr end <= prev
        //curr is (a,b) and prev (c,d)
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int b = curr[1];
            int d = prev[1];

            if (b <= d) {
                continue;
            } else {
                count++;
                prev = curr;
            }
        }

        return count;
    }
    /*
    before sorting:
    [1,4], [3,6], [2,8]
    after sorting a[0] - b[0]:
    [1,4], [2,8], [3,6]

    counter = 2;

    prev = arr[1]
    prev = [2,8] (c,d)

    for start at index 2:
    curr = arr[2] -> [3,6] (a,b)
    prev = arr[1] -> [2,8]

     2 <= 3 && 8 <= 6 ? count++ && prev = curr : continue;
    */
}
