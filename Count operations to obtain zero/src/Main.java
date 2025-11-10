public class Main {
    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 3;
        int test = countOperations(num1, num2);
        System.out.println(test);
    }

    public static int countOperations(int num1, int num2) {
        int operations = 0;

        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            operations++;
        }

        return operations;
    }
}
