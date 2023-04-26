public class Main {
    public static void main (String[] args) {
        String allowed = "ab";
        String[] words= {"ad","bd","aaab","baa","badab"};
        countConsistentStrings(allowed, words);

    }


    public static int countConsistentStrings (String allowed, String[] words) {
        int count = 0;
        for (int i=0; i<words.length; i++) {
           String temp = words[i];
            System.out.println(temp);
            boolean isConsistent = false;
          for (int j=0; j<temp.length(); j++) {
              if (allowed.indexOf(temp.charAt(j)) == -1) {
                  isConsistent = true;
                  break;
              }
          }
            if (isConsistent) {
                count = count+1;
            }
        }
        System.out.println(count);
        return count;
    }

}

