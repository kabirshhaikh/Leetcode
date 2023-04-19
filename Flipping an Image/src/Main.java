public class Main {
    public static void main (String[] test) {
        int[][] image = {{1,1,0}, {1,0,1}, {0,0,0}};
        flipAndInvertImage(image);
    }

    public static int[][] flipAndInvertImage (int[][] image) {
        int rows = image.length;
        int columns = image[0].length;
        //Creating a new Flipped Array:
        int[][] flippedArray = new int[rows][columns];

        //Flipping the image:
        for (int i=0; i<image.length; i++) {
            for (int j=image[i].length -1 ; j>=0 ; j--) {
                flippedArray[i][j] = 1 - image[i][columns - 1 -j];
            }
        }

        for (int i=0; i<flippedArray.length; i++) {
            for (int j=0; j<flippedArray[i].length; j++) {
                System.out.print(flippedArray[i][j]+ ", ");
            }
        }

        return flippedArray;
    }
}