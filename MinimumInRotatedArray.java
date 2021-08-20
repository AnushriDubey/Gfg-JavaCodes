public class MinimumInRotatedArray {


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
        int a[] = {2,1};
        System.out.println(minEle(a,0,a.length-1));
    }
}
