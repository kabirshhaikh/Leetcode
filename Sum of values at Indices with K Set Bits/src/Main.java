import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(4);
        myList.add(3);
        myList.add(2);
        myList.add(1);
//        myList.add(2);
        int k = 2;
        int test = sumIndicesWithKSetBits(myList, k);
        System.out.println(test);
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sizeOfNums = nums.size();
        int sum = 0;

        for (int i = 0; i < sizeOfNums; i++) {
            int currentIndex = i;
            int count = 0;
            String binaryOfCurrentIndex = Integer.toBinaryString(currentIndex);
            for (int j = 0; j < binaryOfCurrentIndex.length(); j++) {
                char currentChar = binaryOfCurrentIndex.charAt(j);
                if (currentChar == '1') {
                    count = count + 1;
                }
            }
            if (count == k) {
                sum = sum + nums.get(i);
            }
        }

        return sum;
    }
}