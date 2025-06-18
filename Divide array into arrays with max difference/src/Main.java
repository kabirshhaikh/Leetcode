import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        int[][] test = divideArray(nums, k);
        for (int i = 0; i < test.length; i++) {
            int[] current = test[i];
            System.out.print("Row " +i +": ");
            for (int j = 0; j < current.length; j++) {
                System.out.print(current[j] + ", ");
            }
            System.out.println(" ");
        }
    }


    public static int[][] divideArray(int[] nums, int k) {
        List<List<Integer>> myList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 3) {
            if (i + 2 < nums.length) {
                if ((nums[i + 1] - nums[i] <= k) && (nums[i + 2] - nums[i + 1] <= k) && (nums[i+2] - nums[i] <=k)) {
                    myList.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
                }
            }
        }

        if (myList.size() != nums.length / 3) {
            return new int[0][0];
        }
        else {
            int[][] output = new int[myList.size()][myList.get(0).size()];
            int index = 0;

            for (int i=0; i<myList.size(); i++) {
                List<Integer> current = myList.get(i);
                for (int j=0; j<current.size(); j++) {
                    output[index][j] = current.get(j);
                }
                index++;
            }

            return output;
        }
    }
}
