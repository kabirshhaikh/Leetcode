public class Main {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int test = maxArea(height);
        System.out.println(test);
    }


    public static int maxArea(int[] height) {
        int area = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int tempArea = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area, tempArea);
            if (height[left] < height[right]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }


        return area;
    }
}
