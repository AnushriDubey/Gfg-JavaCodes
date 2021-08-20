public class LSS {

    public static int lssRec(int a[], int i, int max, int prev) {
        if(i==0) return max;
        else if(prev == -1) return Math.max(lssRec(a, i-1, max+1, a[i-1]), lssRec(a,i-1, max, prev));
        else if(Math.abs(prev-a[i-1]) == 1) return Math.max(lssRec(a, i-1, max+1, a[i-1]), lssRec(a,i-1, max, prev));
        else return lssRec(a,i-1,max,prev);
    }

    public static void main(String args[]) {
        int n = 7 ,a[] = {2, 3, 4, 9, 4, 5, 6};
        System.out.println(lssRec(a,n,0,-1));
    }
}
