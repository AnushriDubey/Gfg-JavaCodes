public class SSProductUnderK {

    static int k;
    public static int ssProduct(int a[], int i, int s) {
        if(i==0) return 1;
        else if(s*a[i-1] < k) return ssProduct(a,i-1,s*a[i-1])+ ssProduct(a,i-1,s);
        else return ssProduct(a,i-1,s);
    }



    public static void main(String args[]) {
        int a[] = {4, 8, 7, 2};
        k = 50;
        System.out.println(ssProduct(a,4,1)-1);
    }
}
