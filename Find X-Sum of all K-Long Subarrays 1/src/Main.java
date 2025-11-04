import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;
        int[] test = findXSum(nums, k, x);
        System.out.println(Arrays.toString(test));
    }


    public static int[] findXSum(int[] nums, int k, int x) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        //Loop over the first window:
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        list.add(calculateXSum(map, x));

        //Loop over the rest of the window:
        for (int i = k; i < nums.length; i++) {
            int out = nums[i - k];
            int in = nums[i];

            //Update out:
            map.put(out, map.get(out) - 1);
            if (map.get(out) == 0) {
                map.remove(out);
            }

            //Add in which is new:
            map.put(in, map.getOrDefault(in, 0) + 1);

            list.add(calculateXSum(map, x));
        }

        return convertListToArray(list);
    }


    public static int calculateXSum(Map<Integer, Integer> map, int x) {
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(map.entrySet());

        freqList.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            } else {
                return b.getKey() - a.getKey();
            }
        });

        int count = 0;
        int xSum = 0;

        for (Map.Entry<Integer, Integer> myMap : freqList) {
            if (count == x) {
                break;
            }

            int key = myMap.getKey();
            int value = myMap.getValue();

            xSum += key * value;
            count++;
        }

        return xSum;
    }

    public static int[] convertListToArray(List<Integer> out) {
        int[] output = new int[out.size()];

        for (int i = 0; i < out.size(); i++) {
            output[i] = out.get(i);
        }

        return output;
    }
}
