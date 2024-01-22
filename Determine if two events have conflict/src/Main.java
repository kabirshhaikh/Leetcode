import java.time.LocalTime;

public class Main {
    public static void main (String[] args) {
        String[] event1 = {"01:15","02:00"};
        String[] event2 = {"02:00","03:00"};
        boolean test = haveConflict(event1, event2);
        System.out.println(test);
    }



    public static boolean haveConflict (String[] event1, String[] event2) {
        LocalTime interval1Start = LocalTime.parse(event1[0]);
        LocalTime interval1End = LocalTime.parse(event1[1]);

        LocalTime interval2Start = LocalTime.parse(event2[0]);
        LocalTime interval2End = LocalTime.parse(event2[1]);

        boolean output = isIntersecting(interval1Start, interval1End, interval2Start, interval2End);

        return output;
    }


    public static boolean isIntersecting (LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        if (end1.isBefore(start2) || end2.isBefore(start1)) {
            return false;
        }
        return true;
    }
}