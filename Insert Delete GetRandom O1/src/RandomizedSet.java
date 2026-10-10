import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    private final List<Integer> list;
    private final HashMap<Integer, Integer> map;
    private final Random random;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        //if the val is not present in map:
        //->get list.size for index:
        //->make an entry in map.put(val, index)
        //->then add val in list.
        if (!map.containsKey(val)) {
            int index = list.size();
            map.put(val, index);
            list.add(val);
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        //if val is present in map as key
        //->get index of val where i will insert last element.
        //->get index of last element where val will be inserted
        //->swap the elements, put val at index of last position
        //->put last element at index of val.
        //->then map.put(lastElement, index of val)
        //->then remove the last element in O(1) time.
        //return true
        if (map.containsKey(val)) {
            int indexOfVal = map.get(val);
            int indexOfLastElement = list.size() - 1;
            int lastElement = list.get(indexOfLastElement);
            list.set(list.size() - 1, val);
            list.set(indexOfVal, lastElement);
            map.put(lastElement, indexOfVal);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
