import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int countSubarray(int a[], int k) {
        int cnt = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=1;i<a.length;i++) {
            a[i] += a[i-1];
        }
        for(int i=0;i<a.length;i++) {
            int sum = a[i] - k;
            if(a[i] == k) cnt++;

            if(hm.containsKey(sum)) {
                cnt += hm.get(sum);
            }
            if(hm.containsKey(a[i])) {
                hm.put(a[i], hm.get(a[i]) + 1);
            }
            else hm.put(a[i], 1);
        }
        return cnt;
    }

    public static void main(String args[]) {
        int a[] = {0,0,3};
        int k = 3;
        System.out.println(countSubarray(a,k));
    }
}
