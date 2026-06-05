import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        List<String> test = alertNames(keyName, keyTime);
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i) + ", ");
        }
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> output = new ArrayList<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            List<String> temp = map.getOrDefault(name, new ArrayList<>());
            temp.add(time);
            map.put(name, temp);
        }

        for (Map.Entry<String, List<String>> m : map.entrySet()) {
            String name = m.getKey();
            List<String> list = m.getValue();
            Collections.sort(list);

            if (list.size() >= 3) {
                for (int i = 2; i < list.size(); i++) {
                    String first = list.get(i - 2);
                    String curr = list.get(i);
                    String[] firstTime = first.split(":");
                    int firstTotalMins = Integer.parseInt(firstTime[0]) * 60 + Integer.parseInt(firstTime[1]);

                    String[] secondTime = curr.split(":");
                    int secondTotalMins = Integer.parseInt(secondTime[0]) * 60 + Integer.parseInt(secondTime[1]);

                    if ((secondTotalMins - firstTotalMins) <= 60) {
                        output.add(name);
                        break;
                    }
                }
            }
        }

        Collections.sort(output);
        return output;
    }
}
