import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main (String[] args) {
        int[] happiness = {2,3,4,5};
        int k = 1;
        long test = maximumHappinessSum(happiness, k);
        System.out.println(test);
    }
    
    
    public static long maximumHappinessSum (int[] happiness, int k) {
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i=0; i<happiness.length; i++) {
            myList.add(happiness[i]);
        }

        Collections.sort(myList);

        long output = 0;

        for (int i= myList.size()-1; i>=0; i--) {
            if (k == 0) {
                break;
            }
            int currentNumber = myList.get(i);
            if (currentNumber >= 0) {
                output = output + currentNumber;
                for (int j=myList.size()-2; j>=0; j--) {
                    int number = myList.get(j);
                    int num = 0;
                    if (number > 0) {
                        num = number - 1;
                    }
                    myList.set(j, num);
                }
            }
            k = k-1;
        }

        return output;
    }
}
