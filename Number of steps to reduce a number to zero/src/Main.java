public class Main {
    public static void main (String[] args) {
        int num = 14;
        int test = numberOfSteps(num);
        System.out.println(test);
    }


    public static int numberOfSteps (int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0 ) {
                num = num / 2;
                steps = steps + 1;

            }
            else {
                num = num - 1;
                steps = steps + 1;
            }
        }
        return steps;
    }
}
