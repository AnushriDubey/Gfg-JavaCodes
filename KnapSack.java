public class KnapSack {
    static int t[][];
    public static int dpKs(int wt[], int val[], int w, int n) {

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<w+1;j++) {
                if(wt[i-1] <= j) t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                else t[i][j] = t[i-1][j];
            }
        }
        return t[n][w];
    }
    static void printKS(int t[][], int n, int w, int wt[], int val[]) {
        int i=n, j=w+1, res = t[n][w];
        for(i = n; i>0 && res > 0 ; i--) {
            if(res == t[i-1][w]) continue;
            else {
                System.out.print(wt[i-1] + " ");
                res = res - val[i-1];
                w = w - wt[i-1];
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int n =3, w = 50;
        t = new int[n+1][w+1];
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        dpKs(wt, val, 50, 3);
        System.out.println(t[n][w]);
        printKS(t, 3,50,wt, val);
    }
}
