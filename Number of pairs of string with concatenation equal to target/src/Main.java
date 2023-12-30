public class Main {
    public static void main (String[] args) {
        String[] nums = {"777","7","77","77"};
        String target = "7777";
        int test = numOfPairs(nums, target);
        System.out.println(test);
    }


    public static int numOfPairs (String[] nums, String target) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i != j){
                    String str = nums[i].concat(nums[j]);
                    if(str.equals(target)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
