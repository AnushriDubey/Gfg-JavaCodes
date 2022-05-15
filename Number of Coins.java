
Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins. Find the minimum number of coins to make the change. If not possible to make change then return -1.


Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
Output: 2 
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:  
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V*M ≤ 106
All array elements are distinct


// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{

    public int minCnt(int a[], int i, int s) {
        if(s!=0 && i==a.length) return Integer.MAX_VALUE-1;
        else if(s==0) return 0;
        else if(s >= a[i]) 
        return Math.min(1+minCnt(a, i, s-a[i]), minCnt(a,i+1,s));
        else return minCnt(a,i+1,s);
    }
    
    public int dpCnt(int a[], int i, int s, int dp[][]){
        if(s!=0 && i==0) {
            dp[i][s] = Integer.MAX_VALUE-1;
            return dp[i][s];
        }
        else if(s==0) {
            dp[i][s] = 0;
            return dp[i][s];
        }
        if(dp[i][s] !=-1) return dp[i][s];
        else if(s >= a[i-1]) {
            dp[i][s] = Math.min(1+dpCnt(a,i,s-a[i-1], dp), dpCnt(a,i-1,s, dp));
            return dp[i][s];
        }
        else {
            dp[i][s] = dpCnt(a,i-1,s, dp);
            return dp[i][s];
        }
    }
    
	public int minCoins(int coins[], int M, int V) 
	{ 
	    int dp[][] = new int[M+1][V+1];
	    for(int i=0;i<M+1;i++) Arrays.fill(dp[i], -1);
	    int cnt = dpCnt(coins, M, V, dp);
	    if(cnt == Integer.MAX_VALUE || cnt == Integer.MAX_VALUE-1) return -1;
	    else return cnt;
	} 
}
