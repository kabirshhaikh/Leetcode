public class Main {
    public static void main (String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        countSeniors(details);
    }


    public static int countSeniors (String[] details) {
        int count = 0;
        for (int i=0; i<details.length; i++) {
            String currentString = details[i];
            int k=11;
            int m = 12;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(currentString.charAt(k)).append(currentString.charAt(m));
            int output = Integer.parseInt(stringBuilder.toString());
            if (output > 60) {
                count = count + 1;
            }
        }
        System.out.println("Count:" +count);
        return count;
    }

}