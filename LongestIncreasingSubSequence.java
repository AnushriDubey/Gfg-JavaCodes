import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubSequence {
    static Map<String, Integer> mp;
    public static int LISRec(int a[], int n, ArrayList<Integer> al) {
        if(n == a.length) return al.size();
        else {
            if(al.size()==0 || a[n] >= al.get(al.size()-1)) {
                ArrayList<Integer> al2 = new ArrayList<>(al);
                al2.add(a[n]);
                return Math.max(LISRec(a,n+1, al2), LISRec(a,n+1, new ArrayList<>(al)));
            }
            else {
                return LISRec(a,n+1, al);
            }
        }

    }

    public static int LISRecSpace(int a[], int n, int curr) {
        if(n == a.length) return 0;
        else {
            if(curr == -1 || a[n] > curr) {
                return Math.max(1 + LISRecSpace(a,n+1, a[n]), LISRecSpace(a,n+1, curr));
            }
            else {
                return LISRecSpace(a,n+1, curr);
            }
        }

    }

    public static int LISRecSpaceDp(int a[], int n) {
        int lis[] = new int[n];
        lis[0] = 1;
        for(int i=1;i<n;i++) {
            lis[i] = 1;
            for(int j=0;j<i;j++) {
                if(a[i] > a[j] && lis[i]<=lis[j]) lis[i] = 1+lis[j];
            }
        }
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) mx = Math.max(mx, lis[i]);
        return mx;
    }

    public static int LIS(int a[], int n) {
        int len = 0;
        int inc[] = new int[n+1];
        int parent[] = new int[n];
        for(int i=0;i<n;i++) {
            int l = 1, h = len;
            while(l <= h) {
                int m = ((l+h)/2);
                if(a[inc[m]] < a[i]) l = m+1;
                else h = m-1;
            }
            int pos = l;
            inc[pos] = i;
            parent[i] = inc[pos-1];
            if(pos > len) len = pos;
        }
        System.out.println(Arrays.toString(inc));
        return len;
    }

    public static void main(String args[]) {
        int a[] = {0,8,4,12,2,10,6,14,1,9,5, 13,3,11,7,15};
        //System.out.println(LISRec(a, 0, new ArrayList<>()));
        mp = new HashMap<>();
        System.out.println(LISRecSpace(a, 0, -1));
        System.out.println(LISRecSpaceDp(a, a.length));
        System.out.println(LIS(a, a.length));
        //System.out.println(mp);
        //2, 10, 5, 1, 8, 6, 6, 6, 5
    }
}
