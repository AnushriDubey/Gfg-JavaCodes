public class MaximumSubarray {

    public static int maxSum(int a[], int n) {
        int sum = a[0], best = a[0], tmpS = 0, tmpE = 0, s=0,e=0;
        for(int i=1;i<n;i++) {
            if(sum < a[i]) {
                sum = a[i];
                tmpS = i;
                tmpE = i;
            }
            else {
                sum = sum + a[i];
                tmpE = i;
            }
            if(best < sum) {
                best = sum;
                e = tmpE;
                s = tmpS;
            }
            //System.out.println(sum + " " + e + " " + s);
        }
        return best;
    }

    public static int minSum(int a[], int n) {
        int sum = a[0], best = a[0];
        for(int i=1;i<n;i++) {
            sum = Math.min(sum+a[i], a[i]);
            best = Math.min(best, sum);
        }
        return best;
    }

    public static void main(String args[]) {
        int a[]  = {9,-4,-7,9};
        int max1 = maxSum(a,a.length);
        //if(max1 < 0)
        System.out.println(maxSum(a,a.length));
        System.out.println(minSum(a,a.length));
    }
}
