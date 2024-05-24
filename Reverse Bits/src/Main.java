public class Main {
    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        int test = reverseBits(n);
        System.out.println(test);
    }

    public static int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);

        String paddedBinaryString = String.format("%32s", binaryString).replace(' ', '0');

        StringBuilder reversedBinary = new StringBuilder(paddedBinaryString).reverse();

        while (reversedBinary.length() < 32) {
            reversedBinary.append('0');
        }

        int output = Integer.parseUnsignedInt(reversedBinary.toString(), 2);

        return output;
    }
}
