public class Main {
    public static void main (String[] args) {
        String moves = "R_";
        int test = furthestDistanceFromOrigin(moves);
        System.out.println(test);
    }


    public static int furthestDistanceFromOrigin (String moves) {
        int Ls = 0, Rs = 0, Bs = 0;
        for(char c: moves.toCharArray()){
            if(c == 'L')    Ls++;
            else if(c == 'R')    Rs++;
            else    Bs++;
        }
        return Math.abs(Ls-Rs)+Bs;
    }
}
