import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        int n = 7;
        sumOfMultipes(n);
    }


    public static int sumOfMultipes (int n) {
        int count = 0;
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            myList.add(i);
        }
        for (int i=0; i< myList.size(); i++) {
            if (myList.get(i) % 3 == 0 || myList.get(i) % 5 == 0 || myList.get(i) % 7 == 0) {
                count = count + myList.get(i);
            }
        }
        return count;
    }

}