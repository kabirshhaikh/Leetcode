public class Main {
    public static void main (String[] args) {
        int[] startTime = {1,2,3};
        int[] endTime = {3,2,7};
        int queryTime = 4;
        int test = busyStudent(startTime, endTime, queryTime);
        System.out.println(test);
    }


    private static int busyStudent (int[] startTime, int[] endTime, int queryTime) {
        int busyStudents = 0;

        for (int i=0; i<startTime.length; i++) {
            int start = startTime[i];
            int end = endTime[i];
            if (start <= queryTime && end >= queryTime) {
                busyStudents++;
            }
        }

        return busyStudents;
    }
}
