import java.util.ArrayList;

public class ProductOfNumbers {
    ArrayList<Integer> list;

    public ProductOfNumbers () {
        this.list = new ArrayList<>();
    }


    public void add (int num) {
        list.add(num);
    }

    public int getProduct (int k) {
        if (k > list.size()) {
            return 0;
        }

        int product = 1;
        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            if (list.get(i) == 0) {
                return 0;
            }
            product *= list.get(i);
        }
        return product;
    }

    public void printList () {
        if (list.size() == 0) {
            System.out.println("Empty list");
        }
        else {
            for (int i=0; i<list.size(); i++) {
                System.out.print(list.get(i) + ", ");
            }
        }
    }
}
