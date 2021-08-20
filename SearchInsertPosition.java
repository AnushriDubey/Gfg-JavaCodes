public class SearchInsertPosition {

    public static int insertIndex(int a[], int l, int h, int k) {
        while (l<=h) {
            int mid = (l + (h-l)/2);
            if(a[mid] == k) return mid;
            else if(a[mid] < k) l = mid+1;
            else h = mid -1;
        }
        return l;
    }


    public static void main(String args[]) {
        int a[] = {1,3,5,6};
        int k = 0;
        System.out.println(insertIndex(a,0, a.length-1, k));
    }
}
