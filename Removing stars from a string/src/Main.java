public class Main {
    public static void main (String[] args) {
        String s = "abb*cdfg*****x*";
        String test = removeStars(s);
        System.out.println(test);
    }


    public static String removeStars (String s) {
        StringBuilder str = new StringBuilder();
        int ind = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '*'){
                ind--;
                str.deleteCharAt(ind);
            }
            else {
                str.append(s.charAt(i));
                ind++;
            }
        }

        return str.toString();
    }
}