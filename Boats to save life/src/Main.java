import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] people = {1,2};
        int limit = 3;
        int test = numRescueBoats(people, limit);
        System.out.println(test);
    }



    public static int numRescueBoats (int[] people, int limit) {
        int output = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            output++;
        }

        return output;
    }
}