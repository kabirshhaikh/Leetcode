import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] logs = {{2, 4}, {2, 1}, {1, 2}, {3, 1}};
        int x = 2;
        int[] queries = {3, 4};
        int[] test = countServers(n, logs, x, queries);
        System.out.println(Arrays.toString(test));
    }

    //Optimized:
    public static int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // Step 1: Sort logs by time
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));

        // Step 2: Pair each query with its index
        int[][] queriesWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[0]));

        // Step 3: Sliding window over logs
        Map<Integer, Integer> serverFreq = new HashMap<>();
        int[] result = new int[queries.length];
        int start = 0, end = 0;

        for (int[] query : queriesWithIndex) {
            int queryTime = query[0];
            int index = query[1];
            int windowStart = queryTime - x;

            // Expand the window to include logs <= queryTime
            while (end < logs.length && logs[end][1] <= queryTime) {
                int serverId = logs[end][0];
                serverFreq.put(serverId, serverFreq.getOrDefault(serverId, 0) + 1);
                end++;
            }

            // Shrink the window to exclude logs < windowStart
            while (start < logs.length && logs[start][1] < windowStart) {
                int serverId = logs[start][0];
                serverFreq.put(serverId, serverFreq.get(serverId) - 1);
                if (serverFreq.get(serverId) == 0) {
                    serverFreq.remove(serverId);
                }
                start++;
            }

            // Total inactive servers = n - active ones
            result[index] = n - serverFreq.size();
        }

        return result;
    }

    //Brute Force:
//    public static int[] countServers(int n, int[][] logs, int x, int[] queries) {
//        int[] arr = new int[queries.length];
//        int[][] timeInterval = finalQueries(queries, x);
//
//        for (int i = 0; i < timeInterval.length; i++) {
//            int[] currentInterval = timeInterval[i];
//            HashSet<Integer> activeServers = new HashSet<>();
//            for (int j = 0; j < logs.length; j++) {
//                int[] currentLog = logs[j];
//                if (currentLog[1] >= currentInterval[0] && currentLog[1] <= currentInterval[1]) {
//                    activeServers.add(currentLog[0]);
//                }
//            }
//            arr[i] = n - activeServers.size();
//        }
//
//        return arr;
//    }
//
//    public static int[][] finalQueries(int[] queries, int x) {
//        int[][] output = new int[queries.length][2];
//
//        for (int i = 0; i < queries.length; i++) {
//            output[i][0] = queries[i] - x;
//            output[i][1] = queries[i];
//        }
//
//        return output;
//    }
}
