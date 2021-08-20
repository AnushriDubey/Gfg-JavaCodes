import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WineTrading2 {
    public static void main(String args[]) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            long cnt = 0, sum = 0;
            if (n == 0) break;
            else {
                String[] s = br.readLine().split(" ");
                for(int i=0;i<n;i++) {
                    int t = Integer.parseInt(s[i]);
                    sum +=t;
                    cnt += Math.abs(sum);
                }
                System.out.println(cnt);
            }
        }
    }
}
