import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[][] intervals = {{7,10}, {2,4}};
        boolean test = canAttendMeetings(intervals);
        System.out.println(test);
    }

    //before sorting: [0,30], [5,10], [15,20];
    //after sorting: [5,10], [15,20], [0,30];

    public static boolean canAttendMeetings (int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int lastMeetingEndTime = -1;

        for (int i=0; i<intervals.length; i++) {
            int[] currentMeeting = intervals[i];
            int start = currentMeeting[0];
            int end = currentMeeting[1];
            if (start < lastMeetingEndTime) {
                return false;
            }
            lastMeetingEndTime = end;
        }

        return true;
    }
}