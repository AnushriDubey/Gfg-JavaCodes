public class SearchInRotatedSortedArray {

    public static int binarySearch(int a[], int l, int h, int t) {
        if(l<= h) {
            int mid = l + (h-l)/2;
            if(a[mid] == t) return mid;
            if(t<a[mid]) return binarySearch(a,l,mid-1,t);
            else return binarySearch(a,mid+1,h,t);
        }
        return -1;
    }
    public static int minEle(int a[], int l, int h) {
        if(l<=h) {
            int mid = l + (h-l)/2;
            if(mid == 0){
                if(a[mid] < a[mid +1]) return mid;
                else return minEle(a,mid+1, h);
            }
            else if(mid == a.length - 1 ){
                if(a[mid] < a[mid -1]) return mid;
                else return minEle(a, l, mid-1);
            }
            else {
                if(a[mid] < a[mid-1] && a[mid] < a[mid+1]) return mid;
                else if(a[mid]>= a[h]) return minEle(a, mid+1, h);
                else return minEle(a,l,mid-1);
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int a[] = {4,5,6,7,0,1,2};
        int k = 3;
//        if(a.length == 1 && k== a[0]) return 0;
//        else if(a.length == 1) return -1;
        int h = a.length-1;
        int i = minEle(a,0,h);
        int res = -1;
        if(i==0) res = binarySearch(a,0,h,k);
        else if(i == h && k == a[i]) res = i;
        else if(i == h) res = binarySearch(a,0,h-1,k);
        else if(i != -1) {
            if(a[i] == k) res = i;
            else if(a[i+1] <= k && a[h] >= k) res = binarySearch(a,i+1,h,k);
            else res = binarySearch(a,0,i-1,k);
        }
        System.out.println(res);
    }
}
