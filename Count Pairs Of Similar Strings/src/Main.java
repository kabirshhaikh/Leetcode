import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main (String[] args) {
        String[] words = {"aba","aabb","abcd","bac","aabc"};
        int test = similarPairs(words);
        System.out.println(test);
    }

    public static int similarPairs (String[] words) {
        for(int i=0;i<words.length;i++){
            String str = words[i];
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<str.length();j++){
                set.add(str.charAt(j));
            }
            char arr[] = new char[set.size()];
            Iterator<Character> itr = set.iterator();
            String temp = "";
            while(itr.hasNext())  {
                temp=temp+Character.toString(itr.next());
            }
            words[i]=temp;
        }
        int count=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].equals(words[j]))
                    count++;
            }
        }
        return count;
    }
}