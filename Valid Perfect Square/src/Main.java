public class Main {
    public static void main (String[] args) {
        int num = 16;
        boolean test = isPerfectSquare(num);
        System.out.println(test);
    }


    public static boolean isPerfectSquare (int num) {
        double sqr = Math. sqrt(num);
        int val = (int) sqr;
        if((val*val)==num)
        {
            return true;
        }
        return false;
    }
}