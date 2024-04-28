public class Main {
    public static void main (String[] args) {
        int[] nums = {2,4,1,1,6,5};
        int test = countHillValley(nums);
        System.out.println(test);
    }


//Hill if closest element is smaller either on left or right
    //Valley if closest element is larger on either left or right
    public static  int countHillValley (int[] nums) {
        int r = 0, left = nums[0];
        for(int i = 1; i < nums.length - 1; i++)
            if(left < nums[i] && nums[i] > nums[i + 1] || left > nums[i] && nums[i] < nums[i + 1]){
                r++;
                left = nums[i];
            }
        return r;
    }
}