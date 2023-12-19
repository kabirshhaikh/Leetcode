public class Main {
    public static void main (String[] tes) {
        int[] gifts = {56,41,27,71,62,57,67,34,8,71,2,12,52,1,64,43,32,42,9,25,73,29,31};
        int k = 52;
        long test = pickGifts(gifts, k);
        System.out.println(test);
    }



    public static long pickGifts (int[] gifts, int k ) {
        int i=0;
        double arr[]=new double[gifts.length];
        for(int m=0;m<gifts.length;m++){
            arr[m]=gifts[m];
        }

        while(i<k){
            double max=0;
            int ind=0;
            for(int j=0;j<gifts.length;j++){
                if(arr[j]>max){
                    max=arr[j];
                    ind=j;
                }
            }
            arr[ind]=Math.floor(Math.sqrt(max));

            i++;
        }

        long ans=0;
        for(int m=0;m<gifts.length;m++){
            ans+=arr[m];
        }
        return ans;
    }


}