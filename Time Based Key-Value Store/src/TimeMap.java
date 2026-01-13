import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    private static class Entry {
        int timestamp;
        String value;

        public Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Entry>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        Entry entry = new Entry(timestamp, value);
        map.get(key).add(entry);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                resultIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return resultIndex == -1 ? "" : list.get(resultIndex).value;
    }

}
