import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String[] ars) {
        int[][] accounts = {{6,59,64,19,30,76,71,86,90,25,56,17,19,72,61,56,24,40,35,39,67,28,52,11,82,72,8,82,81,47}};
        maximumWealth(accounts);
    }

    public static int maximumWealth (int[][] accounts) {
        int co = 0;
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i=0; i< accounts.length; i++) {
            int counter = 0;
            for (int j=0; j<accounts[i].length; j++) {
                int wealth = accounts[i][j];
                counter = counter + wealth;
            }
            myList.add(counter);
        }

        for (int i=0; i< myList.size(); i++) {
            System.out.print(myList.get(i) + ", ");
        }

        int[] outPut = new int[myList.size()];

        for (int i=0; i<myList.size(); i++) {
            outPut[i] = myList.get(i);
        }

        System.out.println("OutPut Array:" + Arrays.toString(outPut));

        int max_wealth = outPut[0];
        System.out.println("Max WEalth " +max_wealth);

        for (int i=0; i<outPut.length; i++) {
            if (outPut[i] >= max_wealth) {
                max_wealth = outPut[i];
                co = max_wealth;
            }
        }

        System.out.println("Output:" +co);
        return co;
    }

}