import java.util.Arrays;

public class MaximizeCutSegment {

    public static int numCuts(int l, int a[]) {
        int cut=0;
        while(l>0) {
            boolean flag = false;
            for(int i=0;i<3;i++) {
                if(l>=a[i]) {
                    int tmp = l-a[i];
                    if(tmp%a[i] == 0) {
                        l = l-a[i];
                        cut += 1;
                        flag = true;
                    }
                    else {
                        for(int j=0;j<3;j++) {
                            if(tmp%a[j] == 0) {
                                l = l-a[i];
                                cut += 1;
                                flag = true;
                                break;
                            }
                        }
                    }
                    if(flag) break;
                }
            }
        }
        return cut;
    }


    public static int numCutsRec(int l, int a[], int i) {
        if(l ==0 || i==0) return 0;
        else {
            if(l >= a[i-1]) return Math.max(1+ numCutsRec(l-a[i-1],a,i), numCutsRec(l,a,i-1));
            else return numCutsRec(l,a,i-1);
        }
    }

    public static int numCutsDp(int l, int a[]) {
        int dp[][] = new int[4][l+1];
        for(int i=0;i<4;i++) dp[i][0] = 0;
        for(int i=0;i<l+1;i++) dp[0][i] = Integer.MIN_VALUE;
        for(int i=1;i<l+1;i++) {
            if(i%a[0] == 0) dp[1][i] = i/a[0];
            else dp[1][i] = Integer.MIN_VALUE;
        }
        for(int i=1;i<4;i++) {
            for(int j=1;j<l+1;j++) {
                if(j>= a[i-1]) dp[i][j] = Math.max(1+dp[i][j-a[i-1]], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        for(int aa[]: dp) System.out.println(Arrays.toString(aa));
        return dp[3][l];
    }

    public static void main(String args[]) {
        int n = 7 ,x = 5, y = 5, z = 2;
        int a[] = {x,y,z};
        Arrays.sort(a);
        System.out.println(numCuts(n,a));
        System.out.println(numCutsRec(n,a,3));
        System.out.println(numCutsDp(n,a));
    }
}
