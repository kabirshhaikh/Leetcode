import java.util.*;

public class Main {
    public static void main (String[] args) {
        List<List<String>> paths = Arrays.asList(
                Arrays.asList("London","New York"),
                Arrays.asList("New York","Lima"),
                Arrays.asList("Lima","Sao Paulo")
        );
        destCity(paths);
    }

    public static String destCity (List<List<String>> paths) {
        List<String> startingCities = new ArrayList<>();
        HashMap<String, String> myHashMap = new HashMap<>();
        for (int i=0; i< paths.size(); i++) {
            List<String> myInternalList = paths.get(i);
            String start = myInternalList.get(0);
            String destination = myInternalList.get(1);
            startingCities.add(start);
            myHashMap.put(start, destination);
        }

        for (Map.Entry<String, String> myMap : myHashMap.entrySet()) {
            String dest = myMap.getValue();
            boolean hasOutgoingPath = false;
            for (int i=0; i<startingCities.size(); i++) {
                if (startingCities.get(i).equals(dest)) {
                    hasOutgoingPath = true;
                    break;
                }
            }
            if (!hasOutgoingPath) {
                System.out.println("Destination: " +dest);
                return dest;
            }
        }
        return null;
    }

}