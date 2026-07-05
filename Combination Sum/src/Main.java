import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int targetSum = 7;
        List<List<Integer>> test = combinationSum(candidates, targetSum);
        System.out.println(test);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        backtrack(index, candidates, list, output, target);
        return output;
    }

    public static void backtrack(int index, int[] candidates, List<Integer> list, List<List<Integer>> output, int target) {
        //first base case: when reached end of the array or if targetSum < 0 then return: no path found:
        if (index == candidates.length || target < 0) {
            return;
        }

        //second base case:
        //if current val == target sum, record and return:
        if (target == 0) {
            //record snapshot of the list and add to output:
            output.add(new ArrayList<>(list));
            return;
        }

        //add current element to the list:
        list.add(candidates[index]);
        //backtrack the current index because current index is allowed:
        backtrack(index, candidates, list, output, target - candidates[index]);
        //after exploring the choices, remove current element from the array:
        list.remove(list.size() - 1);

        //second backtrack where i dont include current element into the recursive call from next index:
        backtrack(index + 1, candidates, list, output, target);
    }
}
