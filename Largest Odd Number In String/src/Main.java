public class Main {
    public static void main (String[] args) {
        String num = "35427";
        String test = largestOddNumber(num);
        System.out.println(test);
    }

    public static String largestOddNumber (String num) {
        int n = num.length();
        for(int i=n-1; i>=0; i--){
            int a = num.charAt(i)-48;
            if(a%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }


}