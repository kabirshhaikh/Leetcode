public class Main {
    public static void main (String[] args) {
        String[] strs = {"zyx","wvu","tsr"};
        int test = minDeletionSize(strs);
        System.out.println(test);
    }


    public static int minDeletionSize (String[] strs) {
        int stringLength = strs[0].length();
        int output = 0;

        for (int index = 0; index < stringLength; index++) {
            for (int i=1; i<strs.length; i++) {
                if (strs[i].charAt(index) < strs[i-1].charAt(index)) {
                    output++;
                    break;
                }
            }
        }

        return output;
    }
}
