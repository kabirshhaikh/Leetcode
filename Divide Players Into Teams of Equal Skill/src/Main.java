import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void  main (String[] args) {
        int[] skills = {3,2,5,1,3,4};
        long output = dividePlayers(skills);
        System.out.println(output);
    }

    public static long dividePlayers(int[] skill) {
        //so first i sort the array:
        Arrays.sort(skill);

        //now i define a list which will hold int[]:
        List<int[]> pairs = new ArrayList<>();

        //now i define two pointers and form pairs:
        int left = 0; int right = skill.length - 1;

        //after sorting input becomes:
        //[1,2,3,3,4,5]
        //pairs: (1,5), (2,4), (3,3)

        //now i run the while loop:
        while (left < right) {
            int[] pair = new int[2];
            pair[0] = skill[left];
            pair[1] = skill[right];

            //now add pair int[] in the list pairs:
            pairs.add(pair);

            //now increment left and decrement right:
            left++;
            right--;
        }

        //now i have to make sure that all the pairs have same sum, if not then return -1:
        int[] firstPair = new int[2];
        if (pairs.size() > 0) {
            firstPair = pairs.get(0);
        }

        long pairSum = (long) firstPair[0] + firstPair[1];

        for (int i=1; i<pairs.size(); i++) {
            int[] curr = pairs.get(i);
            long currSum = (long) curr[0] + curr[1];
            if (currSum != pairSum) {
                return -1;
            }
        }

        //if we passed the sum check then i loop over pairs again and sum the product of each pair:
        long output = 0;

        for (int i=0; i<pairs.size(); i++) {
            int[] curr = pairs.get(i);
            long product = (long) curr[0] * curr[1];
            output += product;
        }

        //now here i will return output:
        return output;
    }
}
