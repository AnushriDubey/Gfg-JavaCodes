import java.util.Arrays;
import java.util.Scanner;

public class NCR {
    static int dp[][];
    static int calculateNcrRec(int n, int r) {
        if(r == 0) return 1;
        else if(r==1) return n;
        else if(dp[r][n] !=-1) return dp[r][n];
        else {
            int t = dp[r][n-1], t1 = dp[n-1][r-1];
            if(t ==-1) {
                t = calculateNcrRec(n-1,r);
            }
            if(t1 == -1) {
                t1 = calculateNcrRec(n-1, r-1);
            }
            dp[r][n] = t + t1;
            return dp[r][n];
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        dp = new int[r+1][n+1];
        for(int a[]: dp) Arrays.fill(a,-1);
        if(r > n-r) r = n-r;
        System.out.println(calculateNcrRec(n, r));
    }
}
