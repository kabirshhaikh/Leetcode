import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> list = eventualSafeNodes(graph);
        System.out.println(list);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        //here i create hashmap to track directed edges:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //here i create the adjacency list:
        for (int i = 0; i < graph.length; i++) {
            int[] curr = graph[i];
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());

            for (int j = 0; j < curr.length; j++) {
                list.add(curr[j]);
            }

            map.put(i, list);
        }

        //now i define three hashsets one for globally visited, one for path visited and the last one for unsafe nodes, so in dfs method is cycle is detected then i add them to unsafe nodes:
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> pathVisited = new HashSet<>();
        HashSet<Integer> unsafe = new HashSet<>();

        //here i define a list for output to store all safe nodes:
        List<Integer> list = new ArrayList<>();

        //now i run for loop from 0 to < graph.length:
        for (int i = 0; i < graph.length; i++) {
            //if the unsafe set does not contain the node which was detected in any of the dfs calls during recursion, then explore that node:
            if (!unsafe.contains(i)) {
                boolean isSafe = dfs(i, map, visited, pathVisited, unsafe);

                if (!isSafe) {
                    list.add(i);
                }
            }
        }

        //now i sort the list and return it:
        Collections.sort(list);

        return list;
    }

    //this is my helper dfs function:
    public static boolean dfs(int node, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited, HashSet<Integer> pathVisited, HashSet<Integer> unsafe) {
        //base case 1: if the pathVisited has the node then cycle detected, return true:
        if (pathVisited.contains(node)) {
            unsafe.add(node);
            return true;
        }

        //base case 2: if the globally visited set contains this node then return false, meaning already visited and no need to explore again:
        if (visited.contains(node)) {
            return false;
        }

        //if none of the base cases are hit, then i add current node to pathVisited and globally visited set:
        pathVisited.add(node);
        visited.add(node);

        //now i get the list of neighbours:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //now i loop over the neighbours:
        for (int i = 0; i < neighbours.size(); i++) {
            int currNeighbour = neighbours.get(i);
            boolean cycleDetected = dfs(currNeighbour, map, visited, pathVisited, unsafe);

            //if a cycle is detected and dfs returns true then break early no need to go forward and check other neighbours:
            if (cycleDetected) {
                unsafe.add(node);
                return true;
            }
        }

        //after exploring all neighbours i remove current node from path visited, meaning backtracking is done:
        pathVisited.remove(node);

        //and then i return false meaning no cycle was detected if we reached at this point:
        return false;
    }
}

//the algo:
//so in eventualSafeNodes i define two sets, one globally visited and one for path meaning backtracking.

//then i define a hasmap which hold adjacency list (directed edges for a node).

//then i define an output list:

//then i run a for loop starting from 0 to < graph.length:
//if ith element is not in visited then dfs on it
//if the dfs functions returns false, then that means all the paths from that node leads to a terminal node so its safe. I then add that ith element into the list.

//if that ith element returns true then that means cycle is detected and its not safe, one of its path does not reaches terminal node.

//so i dont add it to output list.

//then in the end i return the ouput list in ascending order by sorting it.

//the dfs recursion helper function -> return type is boolean.
//so in here i grab the list from map (getOrDefault).
//base case 1:
//if current node already exits in the path visited then return true, cycle detected.
//base case 2:
//if current node is in visited set, then return false, already explored no need to explore again.

//then i add both nodes in visited and path visited.

//then i run for loop on neighbours
//for each neighbour i run dfs in a if loop, it returns true then break early.

//after for loop is over i remove current node from pathvisited, meaning backtracking done.

//so in the end i return false, meaning no cycle was detected for this node.
