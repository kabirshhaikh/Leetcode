public class Main {
    public static void main(String[] args) {
        int target = 5;
        int maxDoubles = 0;
        int test = minMoves(target, maxDoubles);
        System.out.println(test);
    }

    public static int minMoves(int target, int maxDoubles) {
        int minSteps = 0;

        while (target > 1) {
            //even case:
            if (maxDoubles > 0 && target % 2 == 0) {
                target = target / 2;
                maxDoubles--;
                minSteps++;
            }
            //odd case:
            else if (maxDoubles > 0 && target % 2 == 1) {
                target = target - 1;
                minSteps++;
            } else {
                minSteps = minSteps + target - 1;
                break;
            }
        }

        return minSteps;
    }
}
