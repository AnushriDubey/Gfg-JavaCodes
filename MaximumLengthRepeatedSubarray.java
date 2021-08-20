import java.util.Arrays;

public class MaximumLengthRepeatedSubarray {

    public static int maxSize(int a1[], int a2[], int r1, int r2, int res) {
        if(r1== a1.length || r2==a2.length) return res;
        else if(a1[r1] == a2[r2]) res = maxSize(a1,a2,r1+1,r2+1,res+1);
        return Math.max(res, Math.max(maxSize(a1,a2,r1,r2+1,0), maxSize(a1,a2,r1+1,r2,0)));
    }

    static int dp[][], result = 0;
    public static int maxSizeDp(int a1[], int a2[], int r1, int r2) {
        if(r1== 0 || r2== 0) return 0;
        else if(dp[r1][r2] != -1) return dp[r1][r2];
        else if(a1[r1-1] == a2[r2-1]) dp[r1][r2] = 1 + maxSizeDp(a1, a2, r1 - 1, r2 - 1);
        else dp[r1][r2] = Math.max(maxSizeDp(a1,a2,r1,r2-1), maxSizeDp(a1,a2,r1-1,r2));
        result = Math.max(result, dp[r1][r2]);
        return result;
    }

    public static void main(String args[]) {
        int a1[] = {0,1,1,1,1};
        int a2[] = {1,0,1,0,1};
        dp = new int[a1.length+1][a2.length+1];
        for(int a[]: dp) Arrays.fill(a, -1);
        for(int i=0;i<a1.length;i++) dp[i][0] = 0;
        for(int i=0;i<a2.length;i++) dp[0][i] = 0;
        //System.out.println(maxSize(a1,a2,0, 0,0));
        maxSizeDp(a1,a2,a1.length, a2.length);
        System.out.println(result);
    }
}
