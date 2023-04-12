import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {

        List<List<String>> myList = new ArrayList<List<String>>();

        myList.add(new ArrayList<String>());
        myList.get(0).add("phone");
        myList.get(0).add("blue");
        myList.get(0).add("pixel");

        myList.add(new ArrayList<String>());
        myList.get(1).add("computer");
        myList.get(1).add("silver");
        myList.get(1).add("lenevo");

        myList.add(new ArrayList<String>());
        myList.get(2).add("phone");
        myList.get(2).add("gold");
        myList.get(2).add("iphone");

        String ruleKey = "color";
        String ruleValue = "silver";

        countMatches(myList, ruleKey, ruleValue);
    }

    public static int countMatches (List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int ruleKeyIndex = 0;
        if (ruleKey.equals("type")) {
            ruleKeyIndex = 0;
        }
        else if (ruleKey.equals("color")) {
            ruleKeyIndex = 1;
        }
        else if (ruleKey.equals("name")) {
            ruleKeyIndex = 2;
        }
        for (int i=0; i<items.size(); i++) {
            List<String> list = items.get(i);
            if (list.get(ruleKeyIndex).equals(ruleValue)) {
                count = count + 1;
            }
        }
        System.out.println("Count:" +count);
        return count;
    }
}
