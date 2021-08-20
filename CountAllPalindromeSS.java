import java.util.Arrays;

public class CountAllPalindromeSS {

    public static int palindromicSS(String s, int i, int j) {
        if(i>j) return 0;
        if(i==j) return 1;
        else if(s.charAt(i) == s.charAt(j)) return 1 + palindromicSS(s,i+1,j) + palindromicSS(s, i, j-1);
        else return palindromicSS(s,i+1,j) + palindromicSS(s, i, j-1) - palindromicSS(s, i+1, j-1);
    }


    static int dp[][];
    public static int palindromicSSDp(String s, int i, int j) {
        if(i>j) return 0;
        else if(i==j) return 1;
        else if(dp[i][j] != -1) return dp[i][j];
        else if(s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 1+palindromicSSDp(s,i+1,j)+palindromicSSDp(s,i,j-1);
            return dp[i][j];
        }
        else {
            dp[i][j] = palindromicSSDp(s,i+1,j) + palindromicSSDp(s, i, j-1) - palindromicSSDp(s, i+1, j-1);
            return dp[i][j];
        }

    }

    public static void main(String args[]) {
        String s = "aaaa";
        dp = new int[s.length()+1][s.length()+1];
        for(int a[]: dp) Arrays.fill(a,-1);
        System.out.println(palindromicSS(s,0,s.length()-1));
        System.out.println(palindromicSSDp(s,0,s.length()-1));
    }
}
