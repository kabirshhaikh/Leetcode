import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        String s = "abciiidef";
        int k=3;
        maxVowels(s,k);
    }
    public static int maxVowels (String s, int k) {
        int n = s.length();
        int ans = 0;
        int count = 0;
        for(int i=0;i<n && i<k;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                count++;
            }
        }
        ans = count;
        for(int i=k;i<n;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                count++;
            }
            if(s.charAt(i-k)=='a' || s.charAt(i-k)=='e' || s.charAt(i-k)=='i' || s.charAt(i-k)=='o' || s.charAt(i-k)=='u'){
                count--;
            }
            if(count> ans) ans = count;
        }
        System.out.println(ans);
        return ans;
    }
}