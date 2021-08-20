public class FriendsPairing {

    public static int fpRec(int n) {
        if(n<=2) return n;
        else {
            return fpRec(n-1) + (n-1)*fpRec(n-2);
        }
    }

    public static int fpDp(int n) {
        int dp[] = new int[n+1];
        for(int i=0;i<=n;i++) {
            if(i <= 2) dp[i] = i;
            else{
                dp[i] = dp[i-1] + (i-1)*dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int n = 4;
        System.out.println(fpRec(n));
        System.out.println(fpDp(n));
    }
}
