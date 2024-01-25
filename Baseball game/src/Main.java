import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main (String[] args) {
        String[] operations = {"5","2","C","D","+"};
        int test = calPoints(operations);
        System.out.println(test);
    }


    public static int calPoints (String[] operations) {
        Stack<Integer> stack = new Stack();

        for(String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
}