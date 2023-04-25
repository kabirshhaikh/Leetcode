import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix (String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        else {
            if (strs.length == 1) {
                String prefixWord = String.valueOf(strs[0].charAt(0));
                return prefixWord;
            }
            ArrayList<String> myList = new ArrayList<>();
            //Store prefix into arraylist:
            for (int i=0; i< strs.length; i++) {
                String currentWord = strs[i];
                if (currentWord == null || currentWord == "") {
                    return "";
                }
                else {
                    for (int j=0; j<currentWord.length(); j++) {
                        for (int k=j+1; k<currentWord.length(); k++) {
                            char char1 = currentWord.charAt(j);
                            char char2 = currentWord.charAt(k);
                            String result = String.valueOf(char1) + String.valueOf(char2);
                            myList.add(result);
                        }
                    }
                }
            }
            ArrayList<Boolean> myBooleanList = new ArrayList<>();
            //Extract prefix from arraylist into a variable:

            String prefix;
            if (!myList.isEmpty()) {
                prefix = myList.get(0);
            }
            else {
                return "";
            }


            //Check Prefix:
            for (int i=0; i< strs.length; i++) {
                String currentWord = strs[i];
                for (int j=0; j<currentWord.length(); j++) {
                    for (int k=j+1; k<currentWord.length(); k++) {
                        char char1 = currentWord.charAt(j);
                        char char2 = currentWord.charAt(k);
                        String result = String.valueOf(char1) + String.valueOf(char2);

                        if (result.equals(prefix)) {
                            myBooleanList.add(true);
                        }
                        else {
                            myBooleanList.add(false);
                        }
                    }
                }
            }
            int FALSE = 0;
            int TRUE = 0;

            String output;

            for (int i=0; i<myBooleanList.size(); i++) {
                if (myBooleanList.get(i) == false) {
                    FALSE = FALSE + 1;
                }
                if (myBooleanList.get(i) == true) {
                    TRUE = TRUE + 1;
                }
            }
            if (TRUE > strs.length-1) {
                return prefix;
            }
            else  {
                return "";
            }
        }






    }

}