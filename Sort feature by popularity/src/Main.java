import java.util.*;

public class Main {
    public static void main (String[] args) {
        String[] features = {"cooler","lock","touch"};
        String[] responses = {"i like cooler cooler","lock touch cool","locker like touch"};
        String[] test = sortFeatures(features, responses);
        System.out.println(Arrays.toString(test));
    }


    public static String[] sortFeatures (String[] features, String[] responses) {
        // Step 1: Initialize a map to keep track of feature counts and original indices
        Map<String, Integer> featureCount = new HashMap<>();
        Map<String, Integer> featureIndex = new HashMap<>();

        for (int i = 0; i < features.length; i++) {
            featureCount.put(features[i], 0);
            featureIndex.put(features[i], i);
        }

        // Step 2: Count occurrences of each feature in responses
        for (String response : responses) {
            // Use a set to track features seen in this response
            Set<String> seenFeatures = new HashSet<>();
            String[] words = response.split("\\s+");
            for (String word : words) {
                if (featureCount.containsKey(word) && !seenFeatures.contains(word)) {
                    featureCount.put(word, featureCount.get(word) + 1);
                    seenFeatures.add(word);
                }
            }
        }

        // Step 3: Create a list of features to sort based on count and index
        List<String> featureList = new ArrayList<>(Arrays.asList(features));

        Collections.sort(featureList, new Comparator<String>() {
            public int compare(String a, String b) {
                int countCompare = featureCount.get(b).compareTo(featureCount.get(a));
                if (countCompare != 0) {
                    return countCompare;
                } else {
                    return featureIndex.get(a).compareTo(featureIndex.get(b));
                }
            }
        });

        return featureList.toArray(new String[0]);
    }
}