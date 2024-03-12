public class Main {
    public static void main (String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        boolean test = rotateString(s, goal);
        System.out.println(test);
    }


    public static boolean rotateString (String s, String goal) {
        String str=goal+goal;
        if(s.length()!=goal.length())
            return false;
        return (str.contains(s));
    }
}
