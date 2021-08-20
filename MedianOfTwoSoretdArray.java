import java.util.Arrays;

public class MedianOfTwoSoretdArray {

    public static int medianMerge(int a[], int b[]) {
        int l1 = a.length, l2 = b.length, i=0, j=0, k=0;
        int p[] = new int[l1+l2];
        while(i<l1 && j<l2) {
            if(a[i]<= b[j]) {
                p[k++] = a[i];
                i++;
            }
            else {
                p[k++] = b[j];
                j++;
            }
        }
        while(i<l1) p[k++] = a[i++];
        while(j<l2) p[k++] = b[j++];
        System.out.println(Arrays.toString(p));
        int mid = (l1+l2)/2;
        int mid2 = (l1+l2-1)/2;
        return (p[mid]+p[mid2])/2;
    }

    public static double logMedian(int a[], int b[]) {
        if(b.length<a.length) return logMedian(b, a);
        int l1 = a.length, l2=b.length;
        int low = 0, high = l1, s = (l1+l2+1)/2;
        boolean odd = (l1+l2)%2!=0;
        while (low<=high){
            int pX = (low + (high-low)/2);
            int pY = s - pX;
            int mxL = (pX==0) ? Integer.MIN_VALUE:a[pX-1];
            int minxR = (pX == l1) ? Integer.MAX_VALUE: a[pX];
            int myL = (pY==0) ? Integer.MIN_VALUE: b[pY-1];
            int minyR = (pY==l2) ? Integer.MAX_VALUE: b[pY];
            //System.out.println(minxR + " "+ minyR + " " + mxL + " " + myL);
            if(mxL<=minyR && myL<= minxR) {
                if(odd) return  Math.max(mxL, myL);
                else return (double)(Math.max(mxL, myL)+Math.min(minxR, minyR))/2;
            }
            else if (minxR > minyR) high = pX-1;
            else low = pX+1;
        }
        return 0;
    }



    public static void main(String args[]) {
        int a[] = {1, 12, 15, 16, 38}, b[]= {2, 13, 17, 30, 45};
        System.out.println(medianMerge(a,b));
        System.out.println(logMedian(a,b));
    }
}
