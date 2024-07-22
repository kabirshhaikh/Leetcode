public class Main {
    public static void main (String[] args) {
        int[] color = {0,1,0,0,1};
        int test = numberOfAlternatingGroups(color);
        System.out.println(test);
    }



    public static int numberOfAlternatingGroups (int[] colors) {
        int output = 0;

        for (int i=0; i<colors.length; i++) {
            int next1 = (i+1) % colors.length;
            int next2 = (i+2) % colors.length;
            if (colors[i] != colors[next1] && colors[next1] != colors[next2] && colors[i] == colors[next2]) {
                output = output + 1;
            }
        }

        return output;
    }

}
