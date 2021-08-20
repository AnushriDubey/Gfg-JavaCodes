import java.util.Arrays;

public class MinimumRemoval {

    static int dp[][];

    public static int countDp(int a[], int i, int j, int k) {
        if(i>=a.length || j<0) return 0;
        else if(dp[i][j] != -1) return dp[i][j];
        else if(a[j]-a[i] > k) {
            dp[i][j] = 1+Math.min(countDp(a,i+1,j,k), countDp(a,i,j-1,k));
            return dp[i][j];
        }
        else {
            dp[i][j] = 0;
            return 0;
        }
    }

    public static int countRec(int a[], int i, int j, int k) {
        if(i>=a.length || j<0) return 0;
        else if(a[j]-a[i] > k) return 1+Math.min(countRec(a,i+1,j,k), countRec(a,i,j-1,k));
        else return 0;
    }

    public static void main(String args[]) {
        int a[] = {1, 3, 4, 9, 10, 11, 12, 17, 20} ,k = 4;
        //int a[] = {1, 5, 6, 2, 8},k=2;
        Arrays.sort(a);
        dp = new int[a.length+1][a.length+1];
        for(int aa[]: dp) Arrays.fill(aa,-1);
        System.out.println(countRec(a,0,a.length-1,k));
        System.out.println(countDp(a,0,a.length-1,k));

    }
}
