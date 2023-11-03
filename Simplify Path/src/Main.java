import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main (String[] args) {
        String path = "/home/";
        String tes = simplifyPath(path);
        System.out.println(tes);
    }

    public static String simplifyPath (String path) {
        Stack<String> myStack = new Stack<>();
        String[] testingArray = path.split("/");

        for (int i=0; i< testingArray.length; i++) {
            String currentWord = testingArray[i];
            if (currentWord.equals("..")) {
                if (!myStack.isEmpty()) {
                    myStack.pop();
                }
            }
            else if (currentWord.equals(".") || currentWord.isEmpty()) {
                continue;
            }
            else {
                myStack.push(currentWord);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<myStack.size(); i++ ) {
            sb.append("/");
            sb.append(myStack.get(i));
        }

        if (sb.length() > 0) {
            return sb.toString();
        }
        else {
            return "/";
        }
    }
}
