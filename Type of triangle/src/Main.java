
public class Main {
    public static void main (String[] args) {
        int[] nums = {8,4,2};
        String test = triangleType(nums);
        System.out.println(test);
    }

    public static String triangleType (int[] nums) {
            int a = nums[0], b = nums[1], c = nums[2];
            if (a + b <= c || b +c <= a || a + c <= b) return "none";
            if (a == b && b == c) return "equilateral";
            if (a == b || b == c || a == c) return "isosceles";
            return "scalene";
    }
}