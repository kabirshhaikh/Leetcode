import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FoodRatings {
    class Ref {
        String cuisine;
        int rating;

        public Ref(String cuisine, int rating) {
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    class FoodItem {
        String foodName;
        int rating;

        public FoodItem(String foodName, int rating) {
            this.foodName = foodName;
            this.rating = rating;
        }
    }

    //food -> (cuisine, rating):
    private final Map<String, Ref> foodMap = new HashMap<>();

    //cuisine -> ordered set of FoodItem sorted by (rating desc, name asc)
    private final Map<String, TreeSet<FoodItem>> retrieval = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {

            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            //put into foodMap
            foodMap.put(food, new Ref(cuisine, rating));

            //ensure cuisine TreeSet exists
            retrieval.computeIfAbsent(cuisine, c ->
                    new TreeSet<>((a, b) -> {
                        //rating desc
                        int cmp = Integer.compare(b.rating, a.rating);
                        if (cmp != 0) return cmp;
                        //name asc
                        return a.foodName.compareTo(b.foodName);
                    })
            );

            //add to cuisine leaderboard
            retrieval.get(cuisine).add(new FoodItem(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        Ref ref = foodMap.get(food);
        String cuisine = ref.cuisine;
        int oldRating = ref.rating;

        TreeSet<FoodItem> set = retrieval.get(cuisine);

        set.remove(new FoodItem(food, oldRating));

        set.add(new FoodItem(food, newRating));

        ref.rating = newRating;
    }

    public String highestRated(String cuisine) {
        TreeSet<FoodItem> set = retrieval.get(cuisine);
        return set.first().foodName;
    }
}
