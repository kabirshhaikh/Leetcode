import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        int output = longestCommonPrefix(arr1, arr2);
        System.out.println(output);
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        int output = 0;

        for (int i = 0; i < arr1.length; i++) {
            String current = Integer.toString(arr1[i]);

            for (int j = 1; j <= current.length(); j++) {
                set.add(current.substring(0, j));
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            String current = Integer.toString(arr2[i]);
            for (int j = 1; j <= current.length(); j++) {
                String prefix = current.substring(0, j);
                if (set.contains(prefix)) {
                    output = Math.max(output, prefix.length());
                }
            }
        }

        return output;
    }
}
