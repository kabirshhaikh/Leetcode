public class Main {
    public static void main (String[] args) {
        String blocks = "WBWBBBW";
        int k = 2;
        int test = minimumRecolors(blocks, k);
        System.out.println(test);
    }

    public static int minimumRecolors (String blocks, int k ) {
        int i=0,j=0,count=0;
        int max=Integer.MAX_VALUE;
        while(i<blocks.length()){
            if(blocks.charAt(i)=='W') count++;
            if(i-j+1==k){
                max=Math.min(count,max);
                if(blocks.charAt(j)=='W') count--;
                j++;
            }
            i++;

        }
        return max;
    }

}
