import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        String sentence = "cat and  dog";
        int test = countValidWords(sentence);
        System.out.println(test);
    }


    public static int countValidWords (String sentence) {
        String regex = "^([a-z]+(-?[a-z]+)?)?(!|\\.|,)?$";
        String r2 = "[^0-9]+";
        String[] arr = sentence.split("\\s+");
        int ans = 0;
        for(String s: arr)
        {
            if(s.matches(regex) && s.matches(r2))
            {
                ans++;
            }
        }
        return ans;
    }
}