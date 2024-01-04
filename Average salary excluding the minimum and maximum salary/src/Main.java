import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        double test = average(salary);
        System.out.println(test);
    }

    public static double average (int[] salary) {
        double output = 0;

        int minimumSalary = Integer.MAX_VALUE;

        int maximumSalary = Integer.MIN_VALUE;

        //Loop to find maximum salary:
        for (int i=0; i<salary.length; i++) {
            int currentNumber = salary[i];
            if (currentNumber > maximumSalary ) {
                maximumSalary = currentNumber;
            }
        }

        //Loop to find minimum salary:
        for (int i=0; i<salary.length; i++) {
            int currentNumber = salary[i];
            if (currentNumber < minimumSalary) {
                minimumSalary = currentNumber;
            }
        }

        for (int i=0; i<salary.length; i++) {
            int currentSalary = salary[i];
            if (currentSalary == minimumSalary) {
                salary[i] = 0;
            } else if (currentSalary == maximumSalary) {
                salary[i] = 0;
            }
        }

        double average = 0.0;

        for (int i=0; i<salary.length; i++) {
            average = average + salary[i];
        }

        int n = salary.length - 2;
        output = average / n;

        return output;
    }
}