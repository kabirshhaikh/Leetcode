import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[][] boxTypes = {{1,3}, {2,2}, {3,1}};
        int truckSize = 4;
        int test = maximumUnits(boxTypes, truckSize);
        System.out.println(test);
    }
    public static int maximumUnits (int[][] boxTypes, int truckSize) {
        int units = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < boxTypes.length; i++) {
            int[] box = boxTypes[i];
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];
            if (truckSize >= numberOfBoxes) {
                units += numberOfBoxes * unitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                units += truckSize * unitsPerBox;
                break;
            }
        }
        return units;
    }
}