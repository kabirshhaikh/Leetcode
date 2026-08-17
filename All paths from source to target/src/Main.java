import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> output = allPathsSourceTarget(graph);
        System.out.println(output);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //number of nodes:
        int n = graph.length;

        //first i create adjacency list of graph:
        //hashmap will hold node and its neighbours as list of integer:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i<graph.length; i++) {
            int[] curr = graph[i];

            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            for (int j=0; j<curr.length; j++) {
                list.add(curr[j]);
            }

            map.put(i, list);
        }

        //now i define output which will hold a list of integers:
        List<List<Integer>> output = new ArrayList<>();

        //now i define an empty list to hold all paths that will be added to output:
        List<Integer> path = new ArrayList<>();

        //now i run dfs:
        dfs(0, output, path, map, n);

        //in the end i return output:
        return output;
    }

    //this is my helper recursion function of return type void:
    public static void dfs (int node, List<List<Integer>> output, List<Integer> path, HashMap<Integer, List<Integer>> map, int n) {
        //first i add the node in the path:
        path.add(node);

        //now basecase check: if node == n-1 then take a copy of it add to output and done:
        if (node == n-1) {
            List<Integer> copy = new ArrayList<>();
            for (int i=0; i<path.size(); i++) {
                copy.add(path.get(i));
            }

            output.add(copy);
        }
        else {
            // i get the list of neighbours and go deeper into it:
            List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());
            for (int i=0; i<neighbours.size(); i++) {
                dfs(neighbours.get(i), output, path, map, n);
            }
        }

        //after recursing deeper i remove the current node from path meaning backtracking done: (here i remove the most recent entry of the node)
        path.remove(path.size() - 1);
    }
}


//   0
// /  \
// 1   2
//  \ /
//   3

// so if i create directed adjacency list it will look something like this:
// 0 -> 1 and 2
// 1 -> 3
// 2 -> 3
// 3 -> none

//so the problem demands dfs,
//i need a list which hold list of integer called output, the starting node 0 and map to be passed to the dfs function:
//in the dfs funtion i add the node first from input param:
//then the base case: if node == n-1 then take copy of the list and add to output:
//else:
//loop over neighbours pass the neighbour, output and path list go deeper:
//after loop ends remove the current node from the path.

//so we start from 0:
//path list: (0, )
//is it n-1 no:
// then get neighbours and dfs:
// neighbours = {1, 2}
// dfs(1, output, list(0))
// add 1 to list list = (0,1)
// is 1 n-1 no then get its neighbours:
// neighbours= [3]
// dfs on (3, output and list(0,1))
// add 3 to the list (0,1,3)
// is 3 n-1 yes, take a copy of it and store in List of integer and add that copy to output.
// else branch doent run, remove 3 from list and return

// call returns to 1:
// 1 does not have any other neighbour so we remove 1 from list now list is (0)
// we return the call back to 0.

// now the list state is (0)
// now we loop over next neighbour 2:
// pass dfs(2, output and list (0))
// add 2 to list: (0,2)
// now gets neighbour list and loop on them only 3 is there
// dfs(3, output, list= (0,2))
// add 3 to the list:
// is 3 = n-1 yes,
// take copy of list: (0,2,3) and add to output:
// exit if branch and remove 3 from list and return back to caller 2.

// back to caller 2 no neighbour so remove 2 from list and return back to 0.

// back to 0 and no more neighbours so remove 0 from list now list is empty and return back.

// dfs over and now just return output

