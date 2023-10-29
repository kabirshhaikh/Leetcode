import java.util.Stack;

public class Main {
    public static void main (String[] args) {
        String s = "[";
        boolean test = isValid(s);
        System.out.println(test);
    }


    public static boolean isValid (String s) {
        Stack<Character> myStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char parentheses = s.charAt(i);
            if (parentheses == '(' || parentheses == '[' || parentheses == '{') {
                myStack.push(parentheses);
            } else if (parentheses == ')') {
                if (myStack.isEmpty() || myStack.pop() != '(') {
                    return false;
                }
            } else if (parentheses == ']') {
                if (myStack.isEmpty() || myStack.pop() != '[') {
                    return false;
                }
            } else if (parentheses == '}') {
                if (myStack.isEmpty() || myStack.pop() != '{') {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }
}