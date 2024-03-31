public class Main {
    public static void main(String[] args) {
        int num = 526;
        boolean test = isSameAfterReversals(num);
        System.out.println(test);
    }


    public static boolean isSameAfterReversals(int num) {
        int num1 = num;
        int res = 0;

        while(num1 > 0){
            int r = num1 % 10;
            res = res * 10 + r;
            num1 = num1 / 10;
        }

        while(res > 0){
            int r = res % 10;
            num1 = num1 * 10 + r;
            res = res / 10;
        }

        if(num1 == num){
            return true;
        }
        return false;

    }
}