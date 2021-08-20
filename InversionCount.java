import java.util.Arrays;

public class InversionCount {

    static long inversion(long a[], int l, int h, long cnt) {
        int i = l+1,j=h-1;
        if (l == h) return cnt;
        while(i<j) {
            while(i<h && a[l] >= a[i]) i++;
            while(j>l+1 && a[l] < a[j]) j--;
            if(i<j && a[i] > a[j]) {
                long t = a[i];
                a[i] = a[j];
                a[j] = t;
                cnt++;
                //System.out.println(a[i] + " " + a[j] + " " + i + " " + j);
            }
            //System.out.println(cnt);
        }
        if(l<j && a[l] > a[j]) {
            long t = a[l];
            a[l] = a[j];
            a[j] = t;
            cnt++;
            //System.out.println("2 --> "+ a[l] + " " + a[j] + " " + l + " " + j + " " + cnt);
        }
        //System.out.println(cnt);
        return inversion(a,l, j,0) + inversion(a,j+1, h,0) + cnt;

    }

    public static long partition(long a[], int l, int h) {
        long cnt = 0;
        if(l<h) {
            int mid = (l+h)/2;
            //System.out.println(l + " " + mid + " " + h);
            cnt += partition(a,l,mid);
            cnt += partition(a,mid+1,h);
            cnt += merge(l,mid,h,a);
        }
        return cnt;
    }

    public static long merge(int l,int mid, int h1, long a[]) {
        int len1 = mid-l + 1;
        int len2 = h1-mid;
        long cnt = 0;
        long left[] = new long[len1];
        long right[] = new long[len2];
        int k = 0, k1=0, i1 = 0, j1 = 0, k2 = l;
        //System.out.println(" 111 ---> "+ l + " " + mid + " " + h1 + " " + len1 + " " + len2);
        for(int i=l;i<=mid;i++) {
            left[k++] = a[i];
        }
        for(int i=mid+1;i<=h1;i++) {
            right[k1++] = a[i];
        }
        //System.out.println("left --> " + Arrays.toString(left));
        //System.out.println("right --> " +Arrays.toString(right));
        while(i1 <len1 && j1 <len2) {
            //System.out.println(i1 + " "+ j1);
            if(left[i1] <= right[j1]) {
                a[k2++] = left[i1];
                i1++;
            }
            else {
                cnt += len1 - i1;
                a[k2++] = right[j1];
                j1++;
            }
        }
        //System.out.println(" 222 ---> "+i1 + " " + j1);
        while (i1 <len1) a[k2++] = left[i1++];
        while (j1 <len2) a[k2++] = right[j1++];
        //System.out.println(Arrays.toString(a));
        return cnt;
    }

    public static void inPlaceMerge(int a[], int s, int m ,int e) {
        int s2 = m+1;
        if(a[m]<=a[s2]) return;
        while(s<=m && s2<=e) {
            if(a[s]<=a[s2]) {
                s++;
            }
            else {
                int val = a[s2];
                int p = s2;
                while(p != s) {
                    a[p] = a[p-1];
                    p--;
                }
                a[s] = val;
                s++;
                m++;
                s2++;
            }
        }
    }

    public static void mergeSort(int a[], int l, int h) {
        if(l<h) {
            int mid = l+(h-l)/2;
            mergeSort(a,l, mid);
            mergeSort(a,mid+1, h);
            inPlaceMerge(a,l,mid,h);
        }
    }
    public static void main(String args[]) {
        int n = 42;
        int a[] = {468,335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36,395,204,312,323};
        //int a[] = {1,5,10,3,4,7, 9,6,1};
        int a1[] = {2,1};
        mergeSort(a,0,n-1);
        System.out.println(Arrays.toString(a));
        //System.out.println(inversion(a, 0, n,0));
        //System.out.println(merge(0,1,2,a1));
        //System.out.println(Arrays.toString(a1));
        //System.out.println(partition(a,0,n-1));
        //System.out.println(Arrays.toString(a1));
        //System.out.println(Arrays.toString(a));
    }
}
