public class Main {
    public static void main (String[] args) {
     String s = "coaching";
     String t = "coding";
     int test = appendCharacters(s, t);
     System.out.println(test);
    }

    public static int appendCharacters (String s, String t) {
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length()) {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }else{
                i++;
            }
        }
        return t.length()-j;
    }
}
