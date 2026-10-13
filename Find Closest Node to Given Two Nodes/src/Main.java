import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] edges = {2, 2, 3, -1};
        int node1 = 0;
        int node2 = 1;
        int ans = closestMeetingNode(edges, node1, node2);
        System.out.println(ans);
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        //first create the adjacency list:
        HashMap<Integer, Integer> map = new HashMap<>();

        //now loop over edges to create al:
        //this is going to be a directed graph: i -> edges[i]:
        for (int i = 0; i < edges.length; i++) {
            map.put(i, edges[i]);
        }

        //now i need two maps to track distances and cycle for each node path:
        HashMap<Integer, Integer> dist1 = new HashMap<>();
        HashMap<Integer, Integer> dist2 = new HashMap<>();

        //now i need to perform dfs on two nodes:
        dfs(0, node1, dist1, map);
        dfs(0, node2, dist2, map);

        //now i need two variables to track: 1 -> min distance and 2 -> answer the nodes itself:
        //if two nodes has same distances then return node with smaller value:
        int minDistance = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 0; i < edges.length; i++) {
            if (dist1.containsKey(i) && dist2.containsKey(i)) {
                int maxDistance = Math.max(dist1.get(i), dist2.get(i));
                if (maxDistance < minDistance) {
                    minDistance = maxDistance;
                    answer = i;
                }
            }
        }

        return answer;
    }

    //now here i am going to write dfs recursion function of return type void:
    public static void dfs(int counter, int currentNode, HashMap<Integer, Integer> dist, HashMap<Integer, Integer> map) {
        //base case: if current node == -1 or dist.contains(currentNode) meaning cycle detected so return and break
        //out of recursion:
        if (currentNode == -1 || dist.containsKey(currentNode)) {
            return;
        }

        //now update the distance of current node from the start node:
        dist.put(currentNode, counter);

        //get the neighbour:
        int neighbour = map.get(currentNode);

        //now perform recursion on neighbour:
        dfs(counter + 1, neighbour, dist, map);
    }
}

//so i will need two different maps to track distance for each node from starting node:
//then i will create Adjacency list:
//i will need a counter for each dfs set to 0:
//then i will perform dfs from both nodes:

//dfs helper recursion function of return type void:
//base case: if current node is -1 || pathMap containsKey then cycle detcted and return.
//otherwise pathMap.put(current node, counter)
//counter++;
//dfs on neighbour of this curent node:

// [
//     0 -> 2
//     1 -> 2
//     2 -> 3
//     3 -> -1
// ]

// 0 -> 2 -> 3 -> -1
// 1 -> 2 -> 3 -> -1