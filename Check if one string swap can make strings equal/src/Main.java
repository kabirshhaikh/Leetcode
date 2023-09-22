public class Main {
    public static void main (String[] args) {
        String s1 ="abcd";
        String s2 = "dcba";
        boolean test = areAlmostEqual(s1, s2);
        System.out.println(test);
    }

    public static boolean areAlmostEqual (String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        char[] s2Array = s2.toCharArray();

        int left = 0;
        int right = s2.length()-1;

        while (left < right) {
            char leftCharacter = s2Array[left];
            char rightCharacter = s2Array[right];
            char temp = leftCharacter;
            s2Array[left] = rightCharacter;
            s2Array[right] = temp;
            if (String.valueOf(s2Array).equals(s1)) {
                return true;
            }
            left = left + 1;
            right = right - 1;
        }
        return false;
    }
}
