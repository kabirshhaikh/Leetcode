import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        char[][] picture = {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};
        int test = findLonelyPixel(picture);
        System.out.println(test);
    }

    public static int findLonelyPixel (char[][] picture) {
      int m = picture.length;
      int n = picture[0].length;

      int[] rowCount = new int[m];
      int[] colCount = new int[n];

      //Fill rowCount and colCount arrays on occurrences of B:

      for (int i=0; i<picture.length; i++) {
          char[] current = picture[i];
          for (int j=0; j<current.length; j++) {
              if (current[j] == 'B') {
                  rowCount[i]++;
                  colCount[j]++;
              }
          }
      }

      int lonelyPixels = 0;

      for (int i=0; i<picture.length; i++) {
          char[] current = picture[i];
          for (int j=0; j<current.length; j++) {
              if (current[j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                  lonelyPixels++;
              }
          }
      }

      return lonelyPixels;
    }
}
