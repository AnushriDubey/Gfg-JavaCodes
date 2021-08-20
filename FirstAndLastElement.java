import java.util.Arrays;

public class FirstAndLastElement {

    public static int firstIndex(int a[], int l, int h, int k) {
        int res = -1;
        while (l<=h) {
            int mid = (l + (h-l)/2);
            if(a[mid] == k) {
                res = mid;
                h = mid-1;
            }
            else if(a[mid]<k) l = mid+1;
            else h = mid-1;
        }
        return res;
    }

    public static int lastIndex(int a[], int l, int h, int k) {
        int res = -1;
        while (l<=h) {
            int mid = (l + (h-l)/2);
            if(a[mid] == k) {
                res = mid;
                l = mid+1;
            }
            else if(a[mid]<k) l = mid+1;
            else h = mid-1;
        }
        return res;
    }


    public static void main(String args[]) {
        int a[] = {};
        int k = 0;
        int b[] = new int[2];
        b[0] = firstIndex(a,0,a.length-1,k);
        b[1] = lastIndex(a,0,a.length-1,k);
        System.out.println(Arrays.toString(b));
    }
}
