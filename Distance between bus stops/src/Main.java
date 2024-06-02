public class Main {
    public static void main (String[] args) {
        int[] distance = {1,2,3,4};
        int start = 0;
        int destination = 1;
        int test = distanceBetweenBusStops(distance, start, destination);
        System.out.println(test);
    }


    public static int distanceBetweenBusStops (int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int clockDistance = 0;
        for (int i=start; i<destination; i++) {
            clockDistance = clockDistance + distance[i];
        }

        int totalDistance = 0;
        for (int i=0; i<distance.length; i++) {
            totalDistance = totalDistance + distance[i];
        }

        int total = totalDistance - clockDistance;

        int output = 0;

        if (clockDistance < total) {
            output = clockDistance;
        }
        else {
            output = total;
        }

        return output;
    }
}
