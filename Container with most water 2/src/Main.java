public class Main {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int test = maxArea(height);
        System.out.println(test);
    }

    public static int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int maximumArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > maximumArea) {
                maximumArea = area;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maximumArea;
    }
}
