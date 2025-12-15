import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] code = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive = {true, true, true, true};
        List<String> output = validateCoupons(code, businessLine, isActive);
        System.out.println("Output begins..");
        System.out.println(" ");
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + ", ");
        }
        System.out.println(" ");
        System.out.println("Output ends..");
    }


    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> output = new ArrayList<>();
        List<String> businesses = getListOfBusiness();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < code.length; i++) {
            boolean isValidCode = code[i] != null && code[i].matches("^[a-zA-Z0-9_]+$");
            boolean isValidBusiness = businesses.contains(businessLine[i]);
            boolean isValidActive = isActive[i];

            if (isValidCode && isValidBusiness && isValidActive) {
                if (!map.containsKey(businessLine[i])) {
                    List<String> newArrayList = new ArrayList<>();
                    map.put(businessLine[i], newArrayList);
                }

                map.get(businessLine[i]).add(code[i]);
            }
        }

        for (int i = 0; i < businesses.size(); i++) {
            String business = businesses.get(i);

            List<String> listOfCodes;

            if (map.containsKey(business)) {
                listOfCodes = map.get(business);
                Collections.sort(listOfCodes);

                if (listOfCodes.size() == 1) {
                    output.add(listOfCodes.get(0));
                } else {
                    output.addAll(listOfCodes);
                }
            }
        }

        return output;
    }

    public static List<String> getListOfBusiness() {
        List<String> businesses = new ArrayList<>();

        businesses.add("electronics");
        businesses.add("grocery");
        businesses.add("pharmacy");
        businesses.add("restaurant");

        return businesses;
    }
}
