package String;

import java.util.Arrays;

public class EditDistance {
    public static int LCSUtil(String s, String t) {
        if(s.equals(t)) return 0;
        else {
            //System.out.println(recusiveLCS(s,t,s.length(),t.length()));
            int a1[] = new int[26];
            int a2[] = new int[26];
            for(int i=0;i<s.length();i++) {
                a1[s.charAt(i)-'a']++;
            }
            for(int i=0;i<t.length();i++) {
                a2[t.charAt(i)-'a']++;
            }
            int dp[][] = new int[s.length()+1][t.length()+1];
            for(int [] a: dp) Arrays.fill(a,-1);
            for(int i=0;i<s.length()+1;i++) dp[i][0] = 0;
            for(int i=0;i<t.length()+1;i++) dp[0][i] = 0;
            //return Math.max(s.length(), t.length()) - dpLCS(s,t,s.length(),t.length(),dp);
            dpLCS(s,t,s.length(),t.length(),dp);
            System.out.println(Arrays.toString(a1));
            System.out.println(Arrays.toString(a2));
            System.out.println(getString(dp,s,t,a1,a2).reverse());
            System.out.println(Arrays.toString(a1));
            System.out.println(Arrays.toString(a2));
            int cnt = 0;
            for(int i=0;i<26;i++) {
                cnt += Math.max(a1[i], a2[i]);
//                if(a1[i] <= a2[i]) {
//                    cnt += a1[i]; //replace
//                    System.out.println("1 --> " + i + " " + cnt);
//                    cnt += a2[i] - a1[i]; // insert
//                    System.out.println("2 --> " + i + " " + cnt);
//                    a1[i] = 0;
//                    a2[i] = 0;
//
//                }
//                else if(a1[i] > a2[i]) {
//                    cnt += a2[i]; // replace
//                    System.out.println("3 --> " + i + " " + cnt);
//                    cnt += a1[i] - a2[i]; //delete
//                    System.out.println("4 --> " + i + " " + cnt);
//                    a2[i] = 0;
//                    a1[i] = 0;
//                }
            }
            System.out.println("cnt = " + cnt);

            return 5;
        }
    }

    public static StringBuilder getString(int dp[][], String s,String t, int a1[], int a2[]) {
        int i = s.length(), j = t.length();
        StringBuilder sb = new StringBuilder();
        while (i>0 && j>0) {
            if(s.charAt(i-1) == t.charAt(j-1)) {
                sb.append(s.charAt(i-1));
                a1[s.charAt(i-1)-'a']--;
                a2[s.charAt(i-1)-'a']--;
                //System.out.println(i + " " + j +" "+ s.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1] > dp[i-1][j]) j--;
            else i--;
        }
        return sb;
    }
    public static int dpLCS(String s, String t, int i, int j, int dp[][]) {
        if(i==0 || j ==0) return 0;
        else if(dp[i][j] !=-1) return dp[i][j];
        else if(s.charAt(i-1) == t.charAt(j-1)) {
            dp[i][j] = 1+dpLCS(s,t,i-1,j-1,dp);
            return dp[i][j];
        }
        else {
            dp[i][j] = Math.max(dpLCS(s,t,i-1,j,dp), dpLCS(s,t,i,j-1,dp));
            return dp[i][j];
        }
    }
    public static int recusiveLCS(String s, String t, int i, int j) {
        if(i == 0 || j==0) return 0;
        else if(s.charAt(i-1) == t.charAt(j-1)) return 1+recusiveLCS(s,t,i-1,j-1);
        else return Math.max(recusiveLCS(s,t,i-1,j), recusiveLCS(s,t,i,j-1));
    }


    public static int edit(String a, String b, int la, int lb) {
        if(la==0) return lb;
        else if(lb==0) return la;
        else if(a.charAt(la-1)==b.charAt(lb-1)) return edit(a,b,la-1,lb-1);
        else return 1+Math.min(edit(a,b, la-1, lb-1), Math.min(edit(a,b, la, lb-1), edit(a,b, la-1,lb)));
    }

    static int dp[][];
    public static int editDp(String a, String b, int la, int lb) {
        if(la==0) return lb;
        else if(lb==0) return la;
        else if(dp[la][lb]!=-1) return dp[la][lb];
        else if(a.charAt(la-1)==b.charAt(lb-1)) {
            dp[la][lb]= editDp(a,b,la-1,lb-1);
            return dp[la][lb];
        }
        else {
            dp[la][lb]=1+Math.min(editDp(a,b, la-1, lb-1), Math.min(editDp(a,b, la, lb-1), editDp(a,b, la-1,lb)));
            return dp[la][lb];
        }
    }

    public static void main(String args[]) {
        String s = "ecfbefdcfca";
        String t = "badfcbebbf";
        dp = new int[s.length()+1][t.length()+1];
        for(int a[]: dp) Arrays.fill(a,-1);
        System.out.println(edit(s,t,s.length(),t.length()));
        System.out.println(editDp(s,t,s.length(),t.length()));
        //System.out.println(s.length() + " " + t.length());
        //System.out.println(LCSUtil(s,t));
    }
}
