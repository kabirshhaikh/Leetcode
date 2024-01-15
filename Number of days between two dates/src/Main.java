import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main (String[] args) {
        String date1 = "2020-01-15";
        String date2 = "2019-12-31";
        int test = daysBetweenDates(date1, date2);
        System.out.println(test);
    }

    public static int daysBetweenDates (String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        long days = Math.abs(ChronoUnit.DAYS.between(d1, d2));
        return (int)days;
    }
}