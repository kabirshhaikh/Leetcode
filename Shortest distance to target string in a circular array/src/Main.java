public class Main {
    public static void main(String[] args) {
        String[] words = {"i","eat","leetcode"};
        String target = "ate";
        int startIndex = 0;
        int test = closeTarget(words, target, startIndex);
        System.out.println(test);
    }


    public static int closeTarget(String[] words, String target, int startIndex) {
        final int n = words.length;
        int result = 200;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int distance = Math.abs(startIndex - i);
                result = Math.min(result, Math.min(distance, n - distance));
            }
        }

        return result == 200 ? -1 : result;
    }

}
