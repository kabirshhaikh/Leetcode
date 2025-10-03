public class Main {
    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        int test = numWaterBottles(numBottles, numExchange);
        System.out.println(test);
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int empties = numBottles;

        while (empties >= numExchange) {
            int newBottles = empties / numExchange;
            totalDrunk += newBottles;
            empties = (empties % numExchange) + newBottles;
        }

        return totalDrunk;
    }
}
