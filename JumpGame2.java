import java.util.Arrays;

public class JumpGame2 {

    public static int minJumpRec(int a[], int i) {
        if(i == a.length-1) return 0;
        int res = Integer.MAX_VALUE;
        for(int j=i+1;j<= (a[i]+i);j++) {
            int jump = minJumpRec(a,j);
            if(jump != Integer.MAX_VALUE) res = Math.min(res, 1+jump);
        }
        return res;
    }

    public static int jumpGame(int a[]) {
        int dp[] = new int[a.length];
        for(int i=1;i<dp.length;i++) dp[i] = Integer.MAX_VALUE;
        for(int i=1;i<a.length;i++) {
            for(int j=0;j<i;j++) {
                if(a[j]+j >= i && dp[j]+1 < dp[i]) dp[i] = 1+dp[j];
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[a.length-1];

    }
    public static void main(String args[]) {
        int a[] = {2,2};
        System.out.println(jumpGame(a));
    }
}
