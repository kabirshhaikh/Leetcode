import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int left = 1;
        int right = 22;
        selfDividingNumber(left, right);
    }

    public static List<Integer> selfDividingNumber (int left, int right) {
        List<Integer> myList = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                myList.add(i);
            }
        }

        return myList;
    }


    public static boolean isSelfDividing(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}