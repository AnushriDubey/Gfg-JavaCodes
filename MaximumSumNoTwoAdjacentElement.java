public class MaximumSumNoTwoAdjacentElement {

    public static int maxSumRec(int a[], int i) {
        if(i >= a.length) return 0;
        else return Math.max(a[i] + maxSumRec(a, i+2), maxSumRec(a, i+1));
    }

    public static int maxSumRecOpp(int a[], int i) {
        if(i == 0) return 0;
        else return Math.max(a[i] + maxSumRecOpp(a, i+2), maxSumRecOpp(a, i+1));
    }
    public static int maxSumDp(int a[]) {
        int dp[] = new int[a.length];
        if(a.length == 1) return a[0];
        else if(a.length >= 2) {
            dp[0] = a[0];
            dp[1] = Math.max(a[1], dp[0]);
        }
        for(int i=2;i<a.length;i++) {
            dp[i] = Math.max(a[i]+dp[i-2], dp[i-1]);
        }
        return dp[a.length-1];
    }

    public static void main(String args[]) {
        int a[] = {5,5,10,100,10,5};
        System.out.println(maxSumRec(a,0));
        System.out.println(maxSumDp(a));
    }

}
