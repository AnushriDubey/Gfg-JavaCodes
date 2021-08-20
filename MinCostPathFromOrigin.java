public class MinCostPathFromOrigin {
    static int r,c, cost=0;
    static int row[] = {0,-1};
    static int col[] = {-1,0};
    static boolean isValid(int m, int n) {
        return m>=0 && m<r && n>=0 && n<c;
    }
//    public static int minCost(int a[][], int m, int n) {
//
//    }

    public static int minCostRec(int a[][], int m, int n) {
        if((m <0 && m < r) || (n <0 && n < c)) return Integer.MAX_VALUE;
        if (m== 0 && n== 0) return a[m][n];
        return a[m][n] + Math.min(minCostRec(a,m,n-1), Math.min(minCostRec(a,m,n+1), Math.min(minCostRec(a,m-1,n), minCostRec(a,m+1,n))));
    }


    public static void main(String args[]) {
        int a[][] = {{9,4,9,9},{6,7,6,4},
                {8,3,3,7},{7,4,9,10}};
        r = a.length;
        c = a[0].length;
        System.out.println(minCostRec(a,3,3));
    }
}
