import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] highways = {{0, 1, 4}, {2, 1, 3}, {1, 4, 11}, {3, 2, 3}, {3, 4, 2}};
        int discounts = 1;
        int output = minimumCost(n, highways, discounts);
        System.out.println(output);
    }

    public static int minimumCost(int n, int[][] highways, int discounts) {
        //first i am going to build an adjacency list:
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        //now loop over the highways to create unidirected al:
        for (int i = 0; i < highways.length; i++) {
            int[] curr = highways[i];
            int source = curr[0];
            int destination = curr[1];
            int toll = curr[2];

            //now get list of source and destination:
            List<int[]> sourceList = map.getOrDefault(source, new ArrayList<>());
            List<int[]> destinationList = map.getOrDefault(destination, new ArrayList<>());

            sourceList.add(new int[]{destination, toll});
            destinationList.add(new int[]{source, toll});

            map.put(source, sourceList);
            map.put(destination, destinationList);
        }

        int[][] dist = new int[n][discounts + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        //now i define pq:
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );
        pq.offer(new int[]{0, 0, 0});

        //now run while loop until pq is not empty:
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int currentCity = polled[0];
            int currentTotalCost = polled[1];
            int currentDiscountsUsed = polled[2];

            if (currentTotalCost > dist[currentCity][currentDiscountsUsed]) {
                continue;
            }

            if (currentCity == n - 1) {
                return currentTotalCost;
            }

            //now grab neighbours:
            List<int[]> neighbours = map.getOrDefault(currentCity, new ArrayList<>());

            for (int i = 0; i < neighbours.size(); i++) {
                int[] currNeighbour = neighbours.get(i);
                int nextCity = currNeighbour[0];
                int toll = currNeighbour[1];

                int newCost = currentTotalCost + toll;

                if (newCost < dist[nextCity][currentDiscountsUsed]) {

                    dist[nextCity][currentDiscountsUsed] = newCost;

                    pq.offer(new int[]{
                            nextCity,
                            newCost,
                            currentDiscountsUsed
                    });
                }

                if (currentDiscountsUsed < discounts) {
                    int discountedCost = currentTotalCost + (toll / 2);

                    int newDiscountsUsed = currentDiscountsUsed + 1;

                    if (discountedCost < dist[nextCity][newDiscountsUsed]) {
                        dist[nextCity][newDiscountsUsed] = discountedCost;
                        pq.offer(new int[]{nextCity, discountedCost, newDiscountsUsed});
                    }
                }
            }

        }

        return -1;
    }
}
