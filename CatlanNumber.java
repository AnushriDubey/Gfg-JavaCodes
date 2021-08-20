import java.math.BigInteger;

public class CatlanNumber {

    static BigInteger dp[];
    public static BigInteger findCatalanRec(int n)
    {
        if(n<=1) return new BigInteger("1");
        BigInteger sum = new BigInteger("0");
        if(dp[n] != null) return dp[n];
        for(int i=0;i<n;i++) {
            BigInteger t =  dp[i], t1 = dp[n-i-1];
            if(t == null) t = findCatalanRec(i);
            if(t1 == null) t1 = findCatalanRec(n-i-1);
            sum = sum.add(t.multiply(t1));
        }
        dp[n] = sum;
        return sum;
    }
    public static void main(String args[]) {
        int n = 5;
        dp= new BigInteger[n+1];
        //System.out.println(dp[0]);
        System.out.println(findCatalanRec(n));
    }
}
