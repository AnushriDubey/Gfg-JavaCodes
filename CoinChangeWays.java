import java.util.Arrays;

public class CoinChangeWays {
    static int dp[][];
    public static int ccWays(int a[], int n, int i) {
        if(n==0) return 1;
        else if(i<=0) return 0;
        else if(a[i-1] <= n) return ccWays(a, n-a[i-1],i) + ccWays(a, n,i-1);
        else return ccWays(a,n,i-1);
    }

    public static int ccWaysDp(int a[], int n, int i) {
        if(n==0) return 1;
        else if (i<=0) return 0;
        else if(dp[i][n] != -1) return dp[i][n];
        else if(a[i-1]<= n) {
            dp[i][n] = ccWaysDp(a,n-a[i-1], i) + ccWaysDp(a, n, i-1);
            return dp[i][n];
        }
        else {
            dp[i][n] = ccWaysDp(a, n, i-1);
            return dp[i][n];
        }
    }

    public static void main(String args[]) {
        int a[] = {2,5,3,6};
        int n = 10 , m = 4;
        dp = new int[m+1][n+1];
        for(int a1[]: dp) Arrays.fill(a1, -1);
        System.out.println(ccWays(a,n,m));
        System.out.println(ccWaysDp(a,n,m));
    }
}
