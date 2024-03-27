import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        int day = 31;
        int month = 8;
        int year = 2019;
        String test = dayOfTheWeek(day, month, year);
        System.out.println(test);
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] days = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        for (int i = 1971; i < year; i++) {
            count += i % 4 == 0 ? 366 : 365;
        }
        for (int i = 0; i < month - 1; i++) {
            count += days[i];
        }
        count += day;
        return week[(count + 4) % 7];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}