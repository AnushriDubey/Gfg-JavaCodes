import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    static class Pair{
        int x, y;
        Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }
        public String toString() {
            return "[" +x+", "+y+ "]";
        }
    }

    public static int maxLenRec(Pair p[], int i, Pair prev) {
        if(i>=p.length) return 0;
        else if(prev.y < p[i].x) return Math.max(1+ maxLenRec(p, i+1, p[i]), maxLenRec(p, i+1,prev));
        else return maxLenRec(p,i+1, prev);
    }

    public static int maxLenDp(Pair p[]) {
        int dp[] = new int[p.length];
        for(int i=0;i<p.length;i++) dp[i] = 1;
        for(int i=1;i<p.length;i++) {
            for(int j=0;j<i;j++) {
                if(p[j].y < p[i].x && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<p.length;i++) max = Math.max(dp[i], max);
        return max;
    }
    public static void main(String args[]) {
        //Pair a[] = {new Pair(5, 24), new Pair(39, 60), new Pair(15,28), new Pair (27,40), new Pair(50,90)};
        Pair a[] = {new Pair(5,10), new Pair(1,11)};
        int n = 5;
        Arrays.sort(a, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.x == o2.x) return o1.y - o2.y;
                return o1.x - o2.x;
            }
        });
        System.out.println(Arrays.toString(a));
        System.out.println(maxLenRec(a, 0, new Pair(0,0)));
        System.out.println(maxLenDp(a));
    }
}
