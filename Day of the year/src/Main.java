
public class Main {
    public static void main (String[] args) {
        String date = "2019-02-10";
        int test = dayOfYear(date);
        System.out.println(test);
    }


    public static int dayOfYear (String date) {
        String[] s = date.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int dayOfTheMonth = Integer.parseInt(s[2]);

        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonths[1] = 29;
        }

        int days = 0;

        for (int i = 0; i < month - 1; i++) {
            days += daysInMonths[i];
        }

        days += dayOfTheMonth;

        return days;
    }
}
