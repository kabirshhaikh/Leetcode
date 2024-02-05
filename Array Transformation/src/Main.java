import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1,6,3,4,3,5};
        transformArray(arr);
    }

    public static List<Integer> transformArray (int[] arr) {
        List<Integer> ans=new ArrayList<>();
        int [] arr2=new int[arr.length];
        Boolean remain=false;
        while(!remain){
            remain=true;
            for(int i=1;i<arr.length-1;i++){
                if (arr[i]<arr[i+1] && arr[i-1]>arr[i]){
                    remain=false;
                    arr2[i]=arr[i]+1;
                    continue;
                }
                if (arr[i]>arr[i+1] && arr[i-1]<arr[i]){
                    remain=false;
                    arr2[i]=arr[i]-1;
                    continue;
                }
                arr2[i]=arr[i];
            }
            for(int i=1;i<arr.length-1;i++){
                arr[i]=arr2[i];
            }

        }
        for(int i=0;i<arr.length;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}