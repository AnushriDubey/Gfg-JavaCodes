public class SwapsRequiredToGroupOnes {


    public static int minSwap(int a[]) {
        int k = 0, n = a.length;
        for(int i=0;i<n;i++) {
            if (a[i] == 1) k++;
        }
        int ans = 0, bad = 0;
        for(int i=0;i<k;i++) {
            if(a[i] == 0) bad++;
        }
        ans = Math.min(bad,ans);
        for(int i=k,j=0;i<n;i++,j++) {
            if(a[j]==0) bad--;
            if(a[i] == 0) bad++;
            ans = Math.min(bad,ans);
        }
        return ans;
    }

    public static void main(String args[]) {
        int a[] = {1, 0, 1, 0, 1, 1};
        System.out.println(minSwap(a));
    }
}
