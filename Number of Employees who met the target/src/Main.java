public class Main {
    public static void main (String[] args) {
        int[] hours = {0,1,2,3,4};
        int target = 2;
        int test = numberOfEmployeesWhoMetTarget(hours, target);
        System.out.println(test);
    }

    public static int numberOfEmployeesWhoMetTarget (int[] hours, int target) {
        int count = 0;
        for (int i=0; i< hours.length; i++) {
            if (hours[i] >= target) {
                count = count + 1;
            }
        }
        return count;
    }

}