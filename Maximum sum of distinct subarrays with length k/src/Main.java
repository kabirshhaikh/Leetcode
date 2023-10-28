import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        int[] nums = {4,4,4};
        int k = 3;
        long test = maximumSubarraySum(nums, k);
        System.out.println(test);
    }

    public static long maximumSubarraySum (int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hmap=new HashMap<>();
        int i=0,j=0;
        long res=0,curr=0;
        for( i=0;i<n;i++)
        {
            while(j<i && (hmap.containsKey(nums[i]) || hmap.size()>=k))
            {
                curr=curr-nums[j];
                hmap.remove(nums[j++]);

            }
            curr+=nums[i];
            if(!hmap.containsKey(nums[i]))
                hmap.put(nums[i],1);
            else
                hmap.put(nums[i],hmap.get(nums[i])+1);

            if (hmap.size()== k)
                res = Math.max(res, curr);
        }
        return res;
    }
}