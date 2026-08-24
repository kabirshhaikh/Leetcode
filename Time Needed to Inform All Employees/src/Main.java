import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int n = 1;
        int headID = 0;
        int[] manager = {-1};
        int[] informTime = {0};
        int output = numOfMinutes(n, headID, manager, informTime);
        System.out.println(output);
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //so first i create an adjacency list here:
        //the hashmap will hold the key as manager[ith element] and list of integer where ith number is getting told about news from the manager:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //now i loop over manager array:
        for (int i=0; i<manager.length; i++) {
            int currentManager = manager[i];
            List<Integer> listOfPeopleGettingReported = map.getOrDefault(currentManager, new ArrayList<>());

            listOfPeopleGettingReported.add(i);

            map.put(currentManager, listOfPeopleGettingReported);
        }

        //after the above for loop the list looks like this:
        // [
        // 2 -> {0,1,3,4},
        // 3 -> {5}
        // ]

        //now i start my dfs which has return type of int from here, my root meaning the headId is 2 in this case:
        int ans = dfs(headID, map, informTime);

        //in the end i return the ans from dfs:
        return ans;
    }

    public static int dfs (int root, HashMap<Integer, List<Integer>> map, int[] informTime) {
        int currentRootInformTime = informTime[root];
        int maxSoFar = 0;

        //now i get the list of employees for this root:
        List<Integer> employees = map.getOrDefault(root, new ArrayList<>());

        //now i loop over employees:
        for (int i=0; i<employees.size(); i++) {
            int currentEmployee = employees.get(i);
            int childResult = dfs(currentEmployee, map, informTime);
            maxSoFar = Math.max(maxSoFar, childResult);
        }

        //in the end i return maxSoFar + currentRootInformTime:
        return currentRootInformTime + maxSoFar;
    }
}


// n = 6
// headID = 2
// manager = [2, 2, -1, 2, 2, 3]
// informTime = [0, 0, 1, 0, 0, 1]

// adjacency list:
// key is manager meaning headId and ith element is the direct report:

// [
//     2 -> {0,1,3,4},
//     3 -> {5}
// ]

// so after creating the adjacency list i need.

// i will start my dfs from headId meaning the root.

// inside the dfs return type int for the base case i will check if current number is null or does not exists meaning we came in depth in one direciton then reuturn 0.

// then i get the list of headId in this case:
// inside i maintain a sum counter for each dfs whatever ans i get from neighbour i add that to sum.
// loop over it, and for each neighbour i get the neighbour list and loop over it.

// in the end i return informTime[current] + max of dfs of neighbours.
