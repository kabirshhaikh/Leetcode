import java.util.HashSet;

public class Main {
    public static void main (String[] args) {
        int[] nums = {1,3,1,2,2};
        int test = countCompleteSubarrays(nums);
        System.out.println(test);
    }


    public static int countCompleteSubarrays (int[] nums) {
        HashSet<Integer>H=new HashSet<>();
        for(int n:nums){
            H.add(n);
        }
        int t=H.size();
        int count=0;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer>set=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                set.add(nums[j]);
                if(set.size()==t){
                    count++;
                }
            }
        }
        return count;
    }
}