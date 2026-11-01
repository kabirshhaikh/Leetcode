import java.util.HashMap;

public class BusBooking {
    private final HashMap<String, Integer> map;
    private int time;

    public BusBooking(int n) {
        this.map = new HashMap<>();
        this.time = 0;
    }

    public void toggle(String seat) {
        //first check if already present then remove and return:
        if (map.containsKey(seat)) {
            int val = map.get(seat);
            map.remove(seat);
            time = time - val;
            return;
        }

        //otherwise
        char letter = seat.charAt(0); //A
        String subString = seat.substring(1); //20
        if (letter == 'A') {
            String keyToLookFor = "B" + subString;
            if (map.containsKey(keyToLookFor)) {
                map.put(seat, 3);
                time = time + 3;
            } else {
                map.put(seat, 1);
                time = time + 1;
            }
        } else if (letter == 'D') {
            String keyToLookFor = "C" + subString;
            if (map.containsKey(keyToLookFor)) {
                map.put(seat, 3);
                time = time + 3;
            } else {
                map.put(seat, 1);
                time = time + 1;
            }
        } else {
            //for B or C its just 1 second:
            map.put(seat, 1);
            time = time + 1;
        }
    }

    public int getTotalTime() {
        return time;
    }

    public int getMinTime() {
        return map.size();
    }
}
