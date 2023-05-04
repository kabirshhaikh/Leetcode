import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String command = "G()(al)";
        interpret(command);
    }

    public static String interpret (String command) {
        ArrayList<Character> myList = new ArrayList<>();
        for (int i=0; i<command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                myList.add('G');
            }
            else if (ch == '(' && command.charAt(i+1) == ')') {
                myList.add('o');
            }
            else if (ch == '(' && command.charAt(i+1) == 'a' && command.charAt(i+2) == 'l' && command.charAt(i+3) == ')') {
                myList.add('a');
                myList.add('l');
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : myList) {
            sb.append(c);
        }
        System.out.println("String:" +sb.toString());
        return sb.toString();
    }

}
