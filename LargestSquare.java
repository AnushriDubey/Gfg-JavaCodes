public class LargestSquare {

    public static int lsq(int m[][],int n, int c) {
        int max =0, s[][] = new int[n][c];
        for(int i=0;i<c;i++) {
            s[0][i] = m[0][i];
            max = Math.max(s[0][i], max);
        }
        for(int i=0;i<n;i++) {
            s[i][0] = m[i][0];
            max = Math.max(s[i][0], max);
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<c;j++) {
                if(m[i][j] == 1) {
                    s[i][j] = Math.min(s[i-1][j-1], Math.min(s[i][j-1], s[i-1][j])) +1;
                    max = Math.max(s[i][j], max);
                }
                else s[i][j] =0;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        int a[][] = {{0, 1,1},
                {1, 1,1}};
        int n=2, m=3;
        System.out.println(lsq(a,n, m));
    }
}
