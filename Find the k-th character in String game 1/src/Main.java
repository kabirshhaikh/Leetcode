public class Main {
    public static void main(String[] args) {
        int k = 5;
        char test = kthCharacter(k);
        System.out.println(test);
    }


    public static char kthCharacter(int k) {
        String word = "a";
        while (word.length() < k) {
            StringBuilder sb = new StringBuilder(word.length());
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                sb.append(c == 'z' ? 'a' : (char)(c + 1));
            }
            word = word + sb.toString();
        }
        return word.charAt(k - 1);
    }
}
