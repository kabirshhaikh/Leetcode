public class Main {
    public static void main (String[] args) {
        String[] strs = {"1","01","001","0001"};
        maximumValue(strs);
    }

    public static int maximumValue (String[] strs) {
        int finalCount = 0;
        for (int i = 0; i < strs.length; i++) {
            String currentWord = strs[i];
            int interalCount;
            if (currentWord.matches("\\d+")) {
                interalCount = Integer.parseInt(currentWord);
            } else {
                interalCount = currentWord.length();
            }
            if (interalCount > finalCount) {
                finalCount = interalCount;
            }
        }
        System.out.println("Output: " + finalCount);
        return finalCount;
    }

}
