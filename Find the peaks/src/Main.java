import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] mountain = {1,4,3,8,5};
        findPeaks(mountain);
    }

    public static List<Integer> findPeaks (int[] mountain) {
        ArrayList<Integer> myList = new ArrayList<>();

        for (int i=1; i<mountain.length-1; i++) {
            if (mountain[i] > mountain[i+1] && mountain[i] > mountain[i-1]) {
                myList.add(i);
            }
        }
        
        return myList;
    }
}