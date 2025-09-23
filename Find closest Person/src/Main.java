public class Main {
    public static void main(String[] args) {
        int x = 2;
        int y = 7;
        int z = 4;
        int test = findClosest(x, y, z);
        System.out.println(test);
    }


    public static int findClosest(int x, int y, int z) {
        int xDistance = Math.abs(z - x);
        int yDistance = Math.abs(z - y);

        if (xDistance < yDistance) {
            return 1;
        } else if (xDistance > yDistance) {
            return 2;
        } else {
            return 0;
        }
    }
}
