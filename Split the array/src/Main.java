import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {8,9,8,5,9,3,3,1,2,1};
        boolean test = isPossibleToSplit(nums);
        System.out.println(test);
    }

    public static boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            if(hm.get(nums[i])>2)
                return false;
        }
        return true;
    }
}