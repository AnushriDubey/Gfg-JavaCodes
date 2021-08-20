public class MaximumProductSubarray {

    public static int product(int a[]) {
        int max = a[0], best = Integer.MIN_VALUE, min = a[0];

        for(int i=1;i<a.length;i++) {
            if(a[i] <= 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(a[i], max * a[i]);
            min = Math.min(a[i], min * a[i]);
            best = Math.max(best, max);
        }
        return best;
    }


    public static void main(String args[]) {
        int a[] = {2,-5,-2,-4,3};
        System.out.println(product(a));
    }
}
