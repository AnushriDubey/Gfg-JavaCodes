import java.util.*;

public class ContainerWithMostWater {

    static class Pair{
        int f, l;
        Pair(int f, int l) {
            this.f = f;
            this.l = l;
        }
        public String toString() {
            return "[" + this.f + ", " + this.l + "]";
        }
    }
    public static int maxHeight(int a[]) {
        int  rl[] = new int[a.length];
        TreeMap<Integer, Pair> tm = new TreeMap<>(Collections.reverseOrder());
        Stack<Pair> stk = new Stack<>();
        int minLr = a[0], minRl = a[a.length-1], max = 0;
        for(int i = a.length-1;i>=0;i--) {
            if(a[i]>minRl) minRl = a[i];
            rl[i] = minRl;
        }
        for(int i=0;i<a.length;i++) {
            if(a[i] > minLr) minLr = a[i];
            int min1 = Math.min(minLr, rl[i]);
            if(tm.containsKey(min1)) {
                Pair p = tm.get(min1);
                p.l = i;
                tm.put(min1, p);
            }
            else {
                tm.put(min1, new Pair(i,i));
            }
        }
        System.out.println(tm);
        for(Map.Entry e: tm.entrySet()) {
            Pair p = (Pair)e.getValue();
            int first = p.f, last = p.l;
            int area = (p.l - p.f) * (Integer) e.getKey();
            boolean flag = true;
            while (!stk.isEmpty() && flag) {
                Pair pp = stk.peek();

                if(pp.l<p.f) {
                    int area2 = (p.l - pp.f) * (Integer) e.getKey();
                    if(area < area2) {
                        area = area2;
                        first = pp.f;
                        last = p.l;
                        stk.pop();
                    }
                    else flag = false;
                }
                else if(pp.l > p.f && p.l < pp.l) {
                    int area2 = (pp.l - p.f) * (Integer) e.getKey();
                    if(area < area2) {
                        area = area2;
                        first = p.f;
                        last = pp.l;
                        stk.pop();
                    }
                    else  flag=false;
                }
                else flag = false;
            }
            max = Math.max(max, area);
            stk.push(new Pair(first,last));
        }
        //System.out.println(max);
        //System.out.println(tm);
        return max;
    }

    public static void main(String args[]) {
        int a[] = {0,2};
        maxHeight(a);
    }
}
