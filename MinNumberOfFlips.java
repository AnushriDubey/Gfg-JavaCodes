package String;

import java.util.Arrays;

public class MinNumberOfFlips {

    public static int minFlip(StringBuilder sb, int i) {
        if(i >= sb.length()) return 0;
        else
        {
            if(sb.charAt(i) == sb.charAt(i-1)) {
                StringBuilder sb1 = new StringBuilder(sb.toString());
                if(sb.charAt(i) == '1') {
                    sb1.setCharAt(i-1,'0');
                    sb.setCharAt(i,'0');
                }
                else {
                    sb1.setCharAt(i-1,'1');
                    sb.setCharAt(i,'1');
                }
                return 1+Math.min(minFlip(sb1,i+2), minFlip(sb, i+2));
            }
            else return minFlip(sb,i+1);
        }
    }

    static int dp[];
    public static int minFlipDp(StringBuilder sb, int i) {
        //System.out.println(sb);
        if(i >= sb.length()) {
            return 0;
        }
        else if(dp[i] != -1) return dp[i];
        else
        {
            if(sb.charAt(i) == sb.charAt(i-1)) {
                StringBuilder sb1 = new StringBuilder(sb.toString());
                if(sb.charAt(i) == '1') {
                    sb1.setCharAt(i-1,'0');
                    sb.setCharAt(i,'0');
                }
                else {
                    sb1.setCharAt(i-1,'1');
                    sb.setCharAt(i,'1');
                }
                dp[i] = 1+Math.min(minFlipDp(sb1,i+2), minFlipDp(sb, i+2));
                return dp[i];
            }
            else {
                dp[i] = minFlipDp(sb,i+1);
                return dp[i];
            }

        }
    }

    public static void main(String args[]) {
        String s = "000001111111100000000000";
        StringBuilder sb = new StringBuilder(s);
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        System.out.println(Arrays.toString(dp));
        System.out.println(minFlip(new StringBuilder(s),1));
        System.out.println(minFlipDp(new StringBuilder(s),1));
        System.out.println(Arrays.toString(dp));
    }
}
