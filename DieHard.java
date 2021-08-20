import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DieHard {
    static int awf[][] = {{3,-5,-20},{2,-10,5}};
    static Map<String, Integer> mp;
    public static int maxTime2(int h, int a, int i) {
        if(h <= 0 || a <= 0) return 0;
        String s = h + "_" + a + "_" + i;
        if(mp.containsKey(s)) return mp.get(s);
        if(i == 0) {
            mp.put(s, 1+ Math.max(maxTime2(h + awf[0][1], a + awf[1][1], 1),
                    maxTime2(h + awf[0][2], a + awf[1][2], 2)));
            return mp.get(s);
        }
        else if(i == 1) {
            mp.put(s, 1 + Math.max(maxTime2(h + awf[0][0], a + awf[1][0], 0),
                    maxTime2(h + awf[0][2], a + awf[1][2], 2)));
            return mp.get(s);
        }
        else {
            mp.put(s, 1+ Math.max(maxTime2(h + awf[0][1], a + awf[1][1], 1),
                    maxTime2(h + awf[0][0], a + awf[1][0], 0)));
            return mp.get(s);
        }
    }


    public static void main(String args[]) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            mp = new HashMap<>();
            String s[] = br.readLine().split(" ");
            int h = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int tt = maxTime2(h+3, a+2, 0);
            //System.out.println(mp);
            System.out.println(tt);
        }

    }
}
