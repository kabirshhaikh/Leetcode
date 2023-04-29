import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] seats = {3,1,5};
        int[] students = {2,7,4};
        minMovesToSeat(seats, students);
    }

    public static int minMovesToSeat (int[] seats, int[] students) {
        int moves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        ArrayList<Integer> myList = new ArrayList<>();
        int i= 0;
        int j= 0;
        while (i<seats.length && j<students.length) {
            int difference = Math.abs(students[j] - seats[i]);
            myList.add(difference);
            i = i+ 1;
            j = j+1;
        }
        for (int k=0; k< myList.size(); k++) {
            moves = moves + myList.get(k);
        }
        return moves;
    }


}
