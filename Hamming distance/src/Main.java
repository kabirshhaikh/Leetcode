public class Main {
    public static void main (String[] args) {
        int x = 1;
        int y = 4;
        int test = hammingDistance(x, y);
        System.out.println(test);
    }


    public static int hammingDistance (int x, int y) {
        String binaryX = Integer.toBinaryString(x);
        String binaryY = Integer.toBinaryString(y);

        int maxLength = Math.max(binaryX.length(), binaryY.length());
        
        binaryX = String.format("%" + maxLength + "s", binaryX).replace(' ', '0');
        binaryY = String.format("%" + maxLength + "s", binaryY).replace(' ', '0');

        int hamming = 0;
        for (int i = 0; i < maxLength; i++) {
            if (binaryX.charAt(i) != binaryY.charAt(i)) {
                hamming++;
            }
        }
        return hamming;
    }
}
