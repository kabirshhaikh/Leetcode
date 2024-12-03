public class Main {
    public static void main (String[] args) {
        String s = "spacing";
        int[] spaces = {0,1,2,3,4,5,6};
        String test = addSpaces(s, spaces);
        System.out.println(test);
    }


    public static String addSpaces (String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if (index < spaces.length && i == spaces[index]) {
                sb.append(" ");
                sb.append(currentChar);
                index = index + 1;
            }
            else {
                sb.append(currentChar);
            }

        }


        return sb.toString();
    }
}
