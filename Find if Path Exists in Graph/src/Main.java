import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;
        boolean ans = validPath(n, edges, source, destination);
        System.out.println(ans);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> al = new HashMap<>();

        //here i create the ajacency list:
        for (int i = 0; i < edges.length; i++) {
            int[] curr = edges[i];
            int node1 = curr[0];
            int node2 = curr[1];

            //here i grab the list of empty list:
            List<Integer> node1List = al.getOrDefault(node1, new ArrayList<>());
            List<Integer> node2List = al.getOrDefault(node2, new ArrayList<>());

            //now node1list gets node2 and node2list gets node1:
            node1List.add(node2);
            node2List.add(node1);

            //then after adding nodes I update the current keys value:
            al.put(node1, node1List);
            al.put(node2, node2List);
        }

        //Now i create queue for bfs:
        Queue<Integer> q = new ArrayDeque<>();

        //and then i create hashset of visited numbers:
        HashSet<Integer> visited = new HashSet<>();

        //now i add source to queue and visited:

        q.offer(source);
        visited.add(source);

        while (!q.isEmpty()) {
            //i pop the top most node:
            int popped = q.poll();

            //if the popped node itself equals destination then return true:
            if (popped == destination) {
                return true;
            }

            //now i get neighbours list for popped node:
            List<Integer> neighbours = al.getOrDefault(popped, new ArrayList<>());

            //now i loop over the neighbours that has not been visited and add them
            //to the queue and visited set:

            for (int i = 0; i < neighbours.size(); i++) {
                //if set does not contain the node then only visit:
                if (!visited.contains(neighbours.get(i))) {
                    //mark it as visited:
                    visited.add(neighbours.get(i));

                    //now add it to the queue:
                    q.offer(neighbours.get(i));
                }
            }
        }

        //if path to destination not found then finally return false:
        return false;
    }
}
