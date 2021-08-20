public class LongestCSS {

    public static int LCSSRec(String a, String b, int i, int j, int max) {
        if(i==0 || j==0) return max;
        else if(a.charAt(i-1) == b.charAt(j-1)) return LCSSRec(a,b, i-1, j-1, max+1);
        else return Math.max(max, Math.max(LCSSRec(a,b,i-1,j,0), LCSSRec(a,b,i,j-1,0)));
    }


    public static int LCSSDp(String a, String b) {
        int dp[][] = new int[a.length()+1][b.length()+1];
        int max = 0;
        for(int i=1;i<a.length()+1;i++) {
            for(int j=1;j<b.length()+1;j++) {
                if(a.charAt(i-1)==b.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    max = Math.max(dp[i][j], max);
                }
                else dp[i][j] =0;
            }
        }
        return max;
    }


    public static void main(String args[]) {
        String s1="ABCDGH", s2="ACDGHR";
        System.out.println(LCSSRec(s1,s2,s1.length(),s2.length(),0));
        System.out.println(LCSSDp(s1,s2));
    }
}
