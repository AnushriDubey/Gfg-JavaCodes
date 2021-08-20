public class MaxSubArray {

    public static void maxSum(int a[]) {
        int sum = a[0], best = Integer.MIN_VALUE,tmpE = 0, tmpS = 0, s = 0, e = 0;
        for(int i=1;i<a.length;i++) {
            if(sum < a[i]) {
                tmpS = i;tmpE =i;
                sum = a[i];
            }
            else if(sum < sum+a[i]) {
                sum = sum + a[i];
                tmpE = i;
            }

            if(best < sum) {
                best = sum;
                s=tmpS;
                e=tmpE;
            }
        }
        for(int i=s;i<=e;i++) {
            System.out.print(a[i]+ " ");
        }
        System.out.println();

    }
    public static void main(String args[]) {
        int a[] = {-2,-3,4,-1,1,5,-7};
        maxSum(a);
    }
}
