import java.util.Random;

public class SearchInRotatedSortedArray2 {


    public static int firstIndex(int a[], int l, int h, int k) {
        int res = h+1;
        while(l<=h) {
            int mid = l + (h-l)/2;
            if(a[mid]==k) {
                res = mid;
                h = mid-1;
            }
            else if(a[mid]>k) l = mid+1;
            else h = mid-1;
        }
        return res;
    }
    public static int minEle(int a[], int l, int h) {
        if(l<=h) {
            int mid = l + (h-l)/2;
            System.out.println(mid + " " + a[mid]);
            if(mid == 0) {
                if(mid+1 < a.length && a[mid] <= a[mid+1]) return mid;
                else if(a.length == 1) return mid;
                else return minEle(a, mid+1, h);
            }
            else if(mid == a.length-1) {
                if(a[mid]<= a[mid-1]) return mid;
                else return minEle(a, l, mid-1);
            }
            else {
                if(a[mid] <= a[mid+1] && a[mid] <= a[mid-1]) return mid;
                else if(a[mid]> a[mid-1]) return minEle(a, l, mid-1);
                else return minEle(a, mid+1, h);
            }
        }
        return -1;
    }

    public static boolean search(int a[], int l, int h, int k) {
        if(l<=h) {
            int mid = l + (h-l)/2;
            if(a[mid] == k) return true;
            else if(a[mid] <= k && a[h] >= k) return search(a, mid+1, h, k);
            else return search(a, l, mid-1, k);
        }
        return false;
    }

    public static void main(String args[]) {
        int a[] = {1};
        int k = 0;
        int indx = minEle(a, 0, a.length-1);
        System.out.println("1- " + indx);
        int t = new Random().nextInt(1);
        System.out.println(t);
    }
}
