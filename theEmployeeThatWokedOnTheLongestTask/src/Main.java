public class Main {
    public static void main (String[] args) {
        int n = 10;
        int[][] logs = {{1,1,}, {3,7}, {2,12}, {7,17}};
        int test = hardestWorker(n,logs);
        System.out.println(test);
    }

    public static int hardestWorker (int n, int[][] logs) {
        int maxTime = logs[0][1];
        int minEmp = logs[0][0];

        for(int i=1; i<logs.length; i++) {
            int timeTaken = logs[i][1] - logs[i-1][1];
            int empId = logs[i][0];

            if(timeTaken > maxTime) {
                maxTime = timeTaken;
                minEmp = empId;
            } else if(timeTaken == maxTime) {
                maxTime = timeTaken;
                minEmp = Math.min(empId, minEmp);
            }
        }

        return minEmp;
    }
}