import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] batteryPercentage = {0,1,2};
        int test = countTestedDevices(batteryPercentage);
        System.out.println(test);
    }


    public static int countTestedDevices(int[] batteryPercentage) {
        ArrayList<Integer> myList = new ArrayList<>();
        int testedDevice = 0;

        for (int i = 0; i < batteryPercentage.length; i++) {
            myList.add(batteryPercentage[i]);
        }

        for (int i = 0; i < myList.size(); i++) {
            int currentNumber = myList.get(i);
            if (currentNumber > 0) {
                for (int j = i + 1; j < myList.size(); j++) {
                    int updatedBattery = Math.max(0, myList.get(j) - 1);
                    myList.set(j, updatedBattery);
                }
                testedDevice = testedDevice + 1;
            }
        }

        return testedDevice;
    }
}
