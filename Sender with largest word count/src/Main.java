import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        String[] message = {"Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"};
        String[] sender = {"Alice","userTwo","userThree","Alice"};
        String test = largestWordCount(message, sender);
        System.out.println(test);
    }



    public static String largestWordCount (String[] messages, String [] senders) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        for (int i = 0; i < messages.length; i++) {
            String currentMessage = messages[i];
            String currentSender = senders[i];
            int wordCount = currentMessage.split(" ").length;

            wordCountMap.put(currentSender, wordCountMap.getOrDefault(currentSender, 0) + wordCount);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            System.out.println("Key: " + key + ", count: " + count);
        }

        String maxSender = "";
        int maxWordCount = 0;

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String sender = entry.getKey();
            int count = entry.getValue();

            if (count > maxWordCount || (count == maxWordCount && sender.compareTo(maxSender) > 0)) {
                maxWordCount = count;
                maxSender = sender;
            }
        }

        return maxSender;
    }
}