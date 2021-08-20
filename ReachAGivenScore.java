import java.util.Arrays;
import java.util.Scanner;

public class ReachAGivenScore {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a[] = {3,5,10};
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int dp [][] = new int[4][n+1];
            for(int i=0;i<4;i++) dp[i][0] = 1;
            for(int i=1;i<n+1;i++) dp[0][i] = 0;
            for(int i=1;i<4;i++) {
                for(int j=1;j<n+1;j++) {
                    if(j>= a[i-1]) dp[i][j] = dp[i][j-a[i-1]] + dp[i-1][j];
                    else dp[i][j] = dp[i-1][j];
                }
            }
            System.out.println(dp[3][n]);
        }
    }
}
