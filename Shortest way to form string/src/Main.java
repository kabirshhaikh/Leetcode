public class Main {
    public static void main (String[] args) {
        String target = "abcbc";
        String source = "abc";
        int test = shortestWay(source, target);
        System.out.println(test);

    }

    public static int shortestWay (String source, String target) {
        if (source.isEmpty()) {
            return -1;
        }

        int sourcePointer = 0;
        int count = 1;

        for (int i = 0; i < target.length(); i++) {
            char targetChar = target.charAt(i);

            if (source.indexOf(targetChar) == -1) {
                return -1;
            }

            while (sourcePointer < source.length() && source.charAt(sourcePointer) != targetChar) {
                sourcePointer++;
            }

            if (sourcePointer == source.length()) {
                sourcePointer = 0;
                count++;
                i--;
            } else {
                sourcePointer++;
            }
        }

        return count;
    }
}
