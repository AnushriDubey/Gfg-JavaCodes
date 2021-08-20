import java.util.Arrays;

public class MCM {
    static int dp[][];
    public static int MCMdp(int a[], int i, int j) {
        if(i>=j) return 0;
        else if(dp[i][j] != -1) return dp[i][j];
        else {
            int res = Integer.MAX_VALUE;
            for(int k=i;k<j;k++) {
                res = Math.min(MCMdp(a,i,k)+MCMdp(a,k+1,j) + a[i-1]*a[k]*a[j], res);
            }
            dp[i][j] = res;
            return res;
        }
    }
    public static int MCMRec(int a[], int i, int j) {
        if(i >= j) return 0;
        else {
            int res = Integer.MAX_VALUE;
            for(int k=i;k<j;k++) {
                res = Math.min(MCMRec(a,i,k)+MCMRec(a,k+1,j) + a[i-1]*a[k]*a[j], res);
            }
            return res;
        }
    }
    public static void main(String args[]) {
        int a[] = {40, 20, 30, 10, 30};
        int n = 5;
        dp = new int[n+1][n+1];
        for(int a1[]: dp) Arrays.fill(a1,-1);
        System.out.println(MCMRec(a,1,n-1));
        System.out.println(MCMdp(a,1,n-1));
    }
}
