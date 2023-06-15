public class Main {
    public static void main (String[] args) {
        int[] flowered = {1,0,0,0,0,1};
        int n = 2;
        boolean test = canPlaceFlowers(flowered, n);
        System.out.println(test);
    }


    public static boolean canPlaceFlowers (int[] flowerbed, int n) {
        int count = 0;
        for (int i=0; i<flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i==0 || flowerbed[i-1] == 0) && (i == flowerbed.length -1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                count = count + 1;
            }
        }
       return count >= n;
    }

}