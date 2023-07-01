public class Main {
    public static void main (String[] args) {
        int k = 2;
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        numberOfSubarrays(nums, k);
    }

    public static int numberOfSubarrays (int[] nums, int k) {
        int i=0;
        int j=0;
        int oddCount=0;
        int ans=0;
        int count=0;

        while(j<nums.length){

            if(nums[j]%2!=0){
                oddCount++;
                ans=0;
            }

            while(oddCount==k){
                ans++;
                if(nums[i]%2!=0){
                    oddCount--;

                }
                i++;
            }
            count+=ans;
            j++;
        }
        System.out.println(count);
        return count;
    }


}