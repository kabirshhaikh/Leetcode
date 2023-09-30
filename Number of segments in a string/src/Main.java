public class Main {
    public static void main (String[] args) {
        String s = "";
        int test = countSegments(s);
        System.out.println(test);
    }


    public static int countSegments (String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            if((i==0||s.charAt(i-1)==' ')&&s.charAt(i)!=' '){
                count++;
            }
        }
        return count;
    }
}