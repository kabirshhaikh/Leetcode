public class Main {
    public static void main (String[] args) {
        String s = "";
        String t = "";
        boolean test = isOneEditDistance(s, t);
        System.out.println(test);
    }


    public static boolean isOneEditDistance (String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();


        if (Math.abs(lengthS - lengthT) > 1) {
            return false;
        }

        int pointerS = 0;
        int pointerT = 0;
        boolean foundDifference = false;

        while (pointerS < lengthS && pointerT < lengthT) {
            if (s.charAt(pointerS) != t.charAt(pointerT)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (lengthS > lengthT) {
                    pointerS++;
                } else if (lengthS < lengthT) {
                    pointerT++;
                } else {
                    pointerS++;
                    pointerT++;
                }
            } else {
                pointerS++;
                pointerT++;
            }
        }

        return foundDifference || (pointerS < lengthS) || (pointerT < lengthT);
    }
}
