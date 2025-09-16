import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] nums = {6, 4, 3, 2, 7, 6, 2};
        List<Integer> test = replaceNonCoprimes(nums);
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + ", ");
        }
    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            while (!stack.isEmpty() && BigInteger.valueOf(current).gcd(BigInteger.valueOf(stack.peek())).intValue() > 1) {
                BigInteger a = BigInteger.valueOf(current);
                BigInteger b = BigInteger.valueOf(stack.pop());
                BigInteger lcm = a.multiply(b).divide(a.gcd(b));
                current = lcm.intValue();
            }

            stack.push(current);
        }

        return new ArrayList<>(stack);
    }
}
