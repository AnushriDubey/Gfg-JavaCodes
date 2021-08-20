import java.util.HashMap;
import java.util.Map;

public class OptimalStrategy {


    public static int optimalSRec(int a[], int i, int j, int k) {
        if(i>=j) return 0;
        else if(k%2==0) return Math.max(a[i] + optimalSRec(a,i+1,j,1), a[j]+ optimalSRec(a,i,j-1,1));
        else {
            return Math.min(optimalSRec(a,i+1,j,0), optimalSRec(a,i,j-1,0));
        }
    }

    static Map<String, Integer> mp;
    public static int optimalSDp(int a[], int i, int j, int k) {
        String s = i+"_"+j+"_"+k;
        if(i>=j) return 0;
        else if(mp.containsKey(s)) return mp.get(s);
        else if(k%2==0) {
            mp.put(s, Math.max(a[i] + optimalSDp(a,i+1,j,1), a[j]+ optimalSDp(a,i,j-1,1)));
            return mp.get(s);
        }
        else {
            mp.put(s, Math.min(optimalSDp(a,i+1,j,0), optimalSDp(a,i,j-1,0)));
            return mp.get(s);
        }
    }

    public static int optimalSRecP(int a[], int i, int j, int k, int p) {
        if(i>=j) return p;
        else if(k%2==0) return Math.min(optimalSRecP(a,i+1,j,1, p+a[i]), optimalSRecP(a,i,j-1,1, a[j]+ p));
        else return Math.max(optimalSRecP(a,i+1,j,0,  p), optimalSRecP(a,i,j-1,0,  p));
    }

    public static void main(String args[]) {
        int n = 4 ,a[] = {8,15,3,7};
        mp = new HashMap<>();
        System.out.println(optimalSRec(a,0,n-1,0));
        System.out.println(optimalSDp(a,0,n-1,0));
        System.out.println(mp);
        //System.out.println(optimalSRecP(a,0,n-1,0,0));
    }
}
