public class KthLargestSum {

    public static int prefixSum(int a[], int n, int k) {
        for(int i=1;i<n;i++) a[i] = a[i-1] + a[i];
        if(k<=n) return a[k-1];
        else if(k > (n*(n+1))/2) return -1;
        else {
            int j =0, p = n, q;
            while(true){
                q = p;
                p = p + (n-j-1);
                if(p >= k) break;
                j++;
            }
            System.out.println(q + " " + p + " " + j);
            int s = k - q + j;
            int tt = a[s] - a[j];
            return tt;
        }
    }
    public static void main(String args[]) {
        int a[] = {10, -10, 20, -40};
        int k = 10;
        System.out.println(prefixSum(a,4,k));
    }
}
