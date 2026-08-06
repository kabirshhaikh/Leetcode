import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int k = 0;
        int[][] invocations = {{1,2}, {0,2}, {0,1}, {3,4}};
        List<Integer> output = remainingMethods(n, k, invocations);
        System.out.println(output);
    }

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        //here i first build the ajacency directed hashmap:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //i loop over invocations and add edges to the map:
        for (int i = 0; i < invocations.length; i++) {
            int[] curr = invocations[i];
            int a = curr[0];
            int b = curr[1];

            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);
        }

        //now i define a hashset which will hold all the chain bug nodes starting from k:
        HashSet<Integer> set = new HashSet<>();

        //now i do recursion to create the bug hashset:
        dfs(map, set, k);

        //at this point the set will have list of nodes from the bug chain

        //now i define a variable called detected which will become true if any node is not present in the set but one of its neighbour is, in that case we early exit as well:
        boolean detected = false;

        for (int i = 0; i < n; i++) {
            List<Integer> neighbours = map.getOrDefault(i, new ArrayList<>());

            for (int j = 0; j < neighbours.size(); j++) {
                if (!set.contains(i) && set.contains(neighbours.get(j))) {
                    detected = true;
                    break;
                }
            }

            //if detected is true then exit out of the loop and return all nodes:
            if (detected) {
                break;
            }
        }

        //here i define a list of output which will hold all the nodes for output:
        List<Integer> output = new ArrayList<>();

        if (detected) {
            //return all nodes from 0 to n-1:
            for (int i = 0; i < n; i++) {
                output.add(i);
            }
        } else {
            //else add only the nodes which are not present hashset to the output list:
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    output.add(i);
                }
            }
        }

        //in the end i return the output list:
        return output;
    }

    public static void dfs(HashMap<Integer, List<Integer>> map, HashSet<Integer> set, int k) {
        //break case:
        //if k is already present in set then return:
        //eg: 1->2->1
        if (set.contains(k)) {
            return;
        }

        //then i add the current key into the set:
        set.add(k);

        //then i getOrDefault the list and loop on it and do dfs:
        List<Integer> list = map.getOrDefault(k, new ArrayList<>());

        //then i loop over list and dfs on all its neighbours:
        for (int i = 0; i < list.size(); i++) {
            dfs(map, set, list.get(i));
        }
    }
}


// So first i create a directed hashmap adjacency list.
// then i will define a hashset which will hold the bug chain nodes.

// Then i start dfs recursion from k, and add all the bug chain nodes into it.

// then i will run for loop on n,
// -> each node meaning each ith i will get or default its list from hashmap

// -> then i will maintain a boolean varible canRemove = false

// -> check if the nodes (key) is not present in the hashset and if the neighbours is presnet then mark detected as true and early exit the for loop
// -> in this case return all ndoes from 0 to n-1.

// -> if detected is true then run for loop from 0 to n - 1 add all nodes to output list and return

// -> else loop from 0 to n - 1 and check if ith element is not in set then add that to output list and in the end return


