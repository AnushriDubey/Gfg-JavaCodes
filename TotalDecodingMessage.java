package String;

public class TotalDecodingMessage {

    static int cnt = 0;
    public static int cntMessageRec(String s, int n) {
        if(n==0 || n==1) return 1;
        if(s.charAt(0) == '0') return 0;
        int cnt =0;
        if(s.charAt(n-1) > '0') {
            cnt = cntMessageRec(s, n-1);
        }
        if(s.charAt(n-1) < '7' && (s.charAt(n-2) == '1' || s.charAt(n-2) == '2')) {
            cnt += cntMessageRec(s,n-2);
        }
        return cnt;
    }

    static long MOD = 1000000007;
    public static long cntMessage(String s, int n) {
        long a[] = new long[n+1];
        if(s.charAt(0) == '0') return 0;
        a[0] = 1; a[1]= 1;
        for(int i=2;i<=n;i++) {
            if(s.charAt(i-1) > '0') a[i] =(a[i] + a[i-1]) % MOD;
            if((s.charAt(i-1) < '7' && s.charAt(i-2) == '2') || s.charAt(i-2) == '1')
                a[i] = (a[i] + a[i-2]) % MOD;
        }
        return a[n];
    }

    public static void main(String args[]) {
        cnt = 0;
        int a[] = new int[5];
        System.out.println(cntMessageRec("12132", 5));
        System.out.println(cntMessage("12132", 5));
        //System.out.println(mp);
        System.out.println("cnt --> " + cnt);
    }
}
