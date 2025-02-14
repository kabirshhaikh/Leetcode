public class Main {
    public static void main (String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println("Product of last 2 numbers is: " + productOfNumbers.getProduct(2));
        System.out.println("Product of last 3 numbers is: " + productOfNumbers.getProduct(3));
        System.out.println("Product of last 4 numbers is: " + productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        productOfNumbers.getProduct(2);
        System.out.println("Product of last 2 numbers is: " + productOfNumbers.getProduct(2));
    }
}
