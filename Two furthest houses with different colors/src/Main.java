public class Main {
    public static void main (String[] args) {
        int[] colors = {0,1};
        int test = maxDistance(colors);
        System.out.println(test);
    }


    public static int maxDistance (int[] colors) {
        int maxDist = Integer.MIN_VALUE;

        for (int i=0; i<colors.length; i++) {
            int currentNumber = colors[i];
            int currentIndex = i;
            int currentDistance = 0;
            for (int j=i+1; j<colors.length; j++) {
                int nextNumber = colors[j];
                int nextIndex = j;
                if (currentNumber != nextNumber) {
                    currentDistance = Math.abs(nextIndex - currentIndex);
                }
            }
            if (currentDistance > maxDist) {
                maxDist = currentDistance;
            }
        }

        return maxDist;
    }
}
