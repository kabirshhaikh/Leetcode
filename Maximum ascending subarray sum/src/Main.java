public class Main {
    public static void main (String[] args) {
        int[] nums = {12,17,15,13,10,11,12};
        int test = maxAscendingSum(nums);
        System.out.println(test);
    }


    public static int maxAscendingSum (int[] nums) {
        int sum=nums[nums.length-1];
        int max=nums[nums.length-1];
        for( int i=nums.length-2;i>=0;i--){
            if( nums[i+1] > nums [i] ){
                sum += nums[i];
            }
            else{
                sum = nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
