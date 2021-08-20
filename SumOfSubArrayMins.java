public class SumOfSubArrayMins {

    public static int minSum(int a[], int n) {
        int sum = 0;
        int b[] = new int[((n+1)*(n))/2];

        for(int i=0;i<n;i++) {
            sum += a[i];
            int min = a[i];
            for(int j=i+1;j<n;j++) {
                if(min > a[j]) min = a[j];
                //System.out.print(min + " ");
                sum += min;
            }
            //System.out.println();
        }
        return sum;
    }

    public static void main(String args[]) {
        int a[] = {11,81,94,43,3};
        int n = a.length;
        System.out.println(minSum(a,n));
    }
}
