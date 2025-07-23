import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        int test = maximumGain(s, x, y);
        System.out.println(test);
    }


    public static int maximumGain(String s, int x, int y) {
        Stack<Character> myStack = new Stack<>();
        int maxPoints = 0;

        String removeFirst = x > y ? "ab" : "ba";
        String removeSecond = x > y ? "ba" : "ab";
        int greaterPoint = Math.max(x, y);
        int lowerPoint = Math.min(x, y);

        maxPoints += returnMaxScore(myStack, s, removeFirst, greaterPoint);
        String extractedString = extractString(myStack);
        myStack.clear();

        if (extractedString.length() > 0) {
            maxPoints += returnMaxScore(myStack, extractedString, removeSecond, lowerPoint);
        }

        return maxPoints;
    }

    public static int returnMaxScore(Stack<Character> myStack, String s, String removeFirst, int greaterPoint) {
        int maxPoints = 0;

        myStack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!myStack.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(myStack.peek()).append(s.charAt(i));
                if (sb.toString().equals(removeFirst)) {
                    myStack.pop();
                    maxPoints += greaterPoint;
                } else {
                    myStack.push(s.charAt(i));
                }
            } else {
                myStack.push(s.charAt(i));
            }
        }

        return maxPoints;
    }

    public static String extractString(Stack<Character> myStack) {
        StringBuilder sb = new StringBuilder();

        while (!myStack.isEmpty()) {
            char current = myStack.pop();
            sb.append(current);
        }

        return sb.reverse().toString();
    }
}
