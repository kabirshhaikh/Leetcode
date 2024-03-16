public class Main {
    public static void main (String[] args) {
        String s= "leetcode";
        String t = "coats";
        int test = minSteps(s, t);
        System.out.println(test);
    }


    public static int minSteps (String s, String t) {
        int[] arrS = func(s);
        int[] arrT = func(t);

        int steps = 0;
        for(int i = 0; i < arrS.length; i++) {
            steps += Math.abs(arrS[i] - arrT[i]);
        }
        return steps;
    }

    public static int[] func(String s){
        int[] arr = new int[26];
        for(char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        return arr;
    }
}