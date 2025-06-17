public class Main {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        int test = longestSubstring(s, k);
        System.out.println(test);
    }

    public static int longestSubstring(String s, int k) {
        int maxLength = 0;

        for (int targetUnique = 1; targetUnique<=26; targetUnique++) {
            int left = 0; int right = 0;
            int freq[] = new int[26];
            int uniqueCount = 0;
            int countAtLeastK = 0;

            while (right < s.length()) {
               int index = s.charAt(right) - 'a';

               //Adding right char to freq:
               if (freq[index] == 0) uniqueCount++;
               freq[index]++;
               if (freq[index] == k) countAtLeastK++;

               //Shrink from left:
                while (uniqueCount > targetUnique) {
                    int leftIndex = s.charAt(left) - 'a';
                    if (freq[leftIndex] == k) countAtLeastK--;
                    freq[leftIndex]--;
                    if (freq[leftIndex] == 0) uniqueCount--;
                    left++;
                }

                if (uniqueCount == countAtLeastK && uniqueCount == targetUnique) {
                    maxLength = Math.max(maxLength, right - left + 1);
                }

                right++;
            }
        }
        
        return maxLength;
    }
}
