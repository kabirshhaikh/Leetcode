import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] mapping = {0,1,2,3,4,5,6,7,8,9};
        int[] nums = {789,456,123};
        int[] test = sortJumbled(mapping, nums);
        System.out.println(Arrays.toString(test));
    }


    public static int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i=0; i<mapping.length; i++) {
            int index = i;
            int map = mapping[i];
            myMap.put(index, map);
        }

        int[] testArray = new int[nums.length];
        Map<Integer, Integer> myMap2 = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            String currentNumber = String.valueOf(nums[i]);
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<currentNumber.length(); j++) {
                int currentChar = Integer.parseInt(String.valueOf(currentNumber.charAt(j)));
                if (myMap.containsKey(currentChar)) {
                    String valueToAppend = String.valueOf(myMap.get(currentChar));
                    sb.append(valueToAppend);
                }
            }
            int numberToAddInTheArray = Integer.parseInt(sb.toString());
            testArray[i] = numberToAddInTheArray;
            myMap2.put(nums[i], numberToAddInTheArray);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(myMap2.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry:: getValue));

        for (int i=0; i<list.size(); i++) {
            nums[i] = list.get(i).getKey();
        }


        return nums;
    }
}
