public class SubsetSum {

    static boolean dp[][];
    public static boolean subsetSumDp(int a[], int s) {
        dp = new boolean[a.length+1][s+1];
        for(int i=0;i<a.length+1;i++) dp[i][0] = true;
        for(int i=1;i<s+1;i++) dp[0][i] = false;
        for(int i=1;i<a.length+1;i++) {
            for(int j=1;j<s+1;j++) {
                if(a[i-1] <= j) dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[a.length][s];
    }
    public static boolean subsetSum(int a[], int s, int i) {
        if(s==0) return true;
        else if(i<=0 && s!=0) return false;
        else if(a[i-1] <= s) return subsetSum(a, s-a[i-1], i-1) || subsetSum(a,s,i-1);
        else return subsetSum(a,s,i-1);
    }
    public static void main(String args[]) {
        int a[] = {1, 5, 11, 5};
        int n = 4;
        int sum =0;
        for(int i=0;i<n;i++) sum += a[i];
        if(sum%2 != 0) System.out.println(0);
        else System.out.println(subsetSum(a,sum/2,n));
        System.out.println(subsetSumDp(a,sum/2));
    }
}
