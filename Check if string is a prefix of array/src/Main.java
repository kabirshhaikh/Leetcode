public class Main {
    public static void main (String[] args) {
        String s = "iloveleetcode";
        String[] words = {"apples","i","love","leetcode"};
        boolean test = isPrefixString(s, words);
        System.out.println(test);
    }

    public static boolean isPrefixString (String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}