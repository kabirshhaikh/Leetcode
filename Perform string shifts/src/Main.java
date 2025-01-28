public class Main {
    public static void main (String[] args) {
        int[][] shifts = {{0,1}, {1,2}};
        String s = "abc";
        String test = stringShift(s, shifts);
        System.out.println(test);
    }

    public static String stringShift (String s, int[][] shift) {
        for (int i=0; i<shift.length; i++) {
            int[] current = shift[i];
            int direction = current[0];
            int rotation = current[1];
            if (direction == 0) {
                s = rotateLeft(s, rotation);
            }
            else {
                s = rotateRight(s, rotation);
            }
        }

        return s;
    }


    private static String rotateLeft (String s, int k) {
        k = k % s.length();
        //a,b,c,d
        if (k == 0) {
            return s;
        }

        //create a temp array:
        char[] string = s.toCharArray();
        char[] temp = new char[s.length()];
        int index = 0;

        //Store elements from k to string.length into temp:
        for (int i=k; i<string.length; i++) {
            temp[index] = string[i];
            index++;
        }

        //Store elements from 0 to k - 1 in temp:
        for (int i=0; i<k; i++) {
            temp[index] = string[i];
            index++;
        }

        StringBuilder sb  = new StringBuilder();
        for (int i=0; i<temp.length; i++) {
            sb.append(temp[i]);
        }

        return sb.toString();
    }

    private static String rotateRight (String s, int k) {
        k = k % s.length();

        if (k == 0) {
            return s;
        }

        char[] string = s.toCharArray();
        char[] temp = new char[s.length()];
        int index = 0;

        //a,b,c,d
        //Store elements string.length - k to string.length in temp:
        for (int i=string.length - k; i<string.length; i++) {
            temp[index] = string[i];
            index++;
        }

        //Store elements from 0 to string.length - k - 1;
        for (int i=0; i<string.length - k; i++) {
            temp[index] = string[i];
            index++;
        }

        StringBuilder sb  = new StringBuilder();

        for (int i=0; i<temp.length; i++) {
            sb.append(temp[i]);
        }

        return sb.toString();
    }
}
