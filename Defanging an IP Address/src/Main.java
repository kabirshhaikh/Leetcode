import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String address = "1.1.1.1";
        defangIPaddr(address);
    }

    public static String defangIPaddr (String address) {
        ArrayList<String> myList = new ArrayList<>();
        for (int i=0; i<address.length(); i++) {
            char ch = address.charAt(i);
            myList.add(String.valueOf(ch));
        }
        for (int i=0; i< myList.size(); i++) {
            String ch = myList.get(i);
            if (ch.equals(".")) {
                myList.remove(i);
                myList.add(i, "[.]");
            }
        }
        String output = String.join("", myList);
        System.out.println(output);
        return output;
    }

}