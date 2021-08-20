import java.util.HashMap;

public class ContinousSubArraySum {

    static class Pair{
        int f, e;
        Pair(int f, int e) {
            this.f = f;
            this.e = e;
        }
    }
    public static int subSum(int a[], int k) {
        for(int i=1;i<a.length;i++) {
            a[i] *= a[i-1];
        }
        int cnt = 0;
        for(int i=0;i<a.length;i++) {
            if(a[i]<k) cnt++;
            for(int j=0;j<i;j++) {
                if(a[i]/a[j] < k) cnt++;
            }
        }
        return cnt;
    }

    public static boolean subSum1(int a[], int k) {
        HashMap<Integer, Pair> hm = new HashMap<>();
        for(int i=1;i<a.length;i++) {
            a[i] += a[i-1];
        }
        int cnt = 0;
        for(int i=0;i<a.length;i++) {
            int diff = a[i]-k;
            if(a[i]%k == 0 && i-0+1>=2) return true;
            if(hm.containsKey(diff)) {
                if(i - hm.get(diff).e + 1 >= 2) return true;
            }
            else {
                hm.put(a[i], new Pair(0,i));
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int a[] = {5,0,0,0};
        int k = 3;
        System.out.println(subSum1(a,k));
    }
}
