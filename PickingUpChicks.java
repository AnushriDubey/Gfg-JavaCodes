import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PickingUpChicks {
    public static long rL(String s) {
        return Long.parseLong(s);
    }
    public static int rI(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String args[]) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tt = rI(br.readLine());
        for(int j =1;j<=tt;j++){
            String s[] = br.readLine().split(" ");
            int b = rI(s[2]);
            int n = rI(s[0]), k = rI(s[1]),  t = rI(s[3]);
            String s1[] = br.readLine().split(" ");
            String s2[] = br.readLine().split(" ");
            //int speed[] = new int[n];
            int swap = 0, cantCover = 0, cnt =0;
            for(int i=n-1;i>=0;i--) {
                int speed = Integer.parseInt(s2[i]);
                int distance = b - Integer.parseInt(s1[i]);
                int canCover = t * speed;
                if(distance <= canCover) {
                    cnt++;
                    swap = swap + cantCover;
                }
                else cantCover++;
                if(cnt == k) break;
            }
            if(cnt >= k) System.out.println("Case #"+j+ ": " + swap);
            else System.out.println("Case #"+j+ ": IMPOSSIBLE");
        }
    }
}
