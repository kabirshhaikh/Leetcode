public class Main {
    public static void main (String[] args) {
        String s = "abc";
        boolean test = validPalindrome(s);
        System.out.println(test);
    }

    public static boolean validPalindrome (String s) {
        int left=0,right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                return check(s,left+1, right) || check(s,left, right-1);
            }
        }
        return true;
    }

    public static boolean check(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }

}