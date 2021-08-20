public class PeakElement {


    public static int peak(int a[], int l, int h) {
        if(l<=h) {
            int mid = l + (h-l)/2;
            if(mid == a.length -1){
                if(a[mid] > a[mid-1]) return mid;
                else return peak(a,l,mid-1);
            }
            else if(mid == 0){
                if(a[mid]>a[mid+1]) return mid;
                else return peak(a,mid+1, h);
            }
            else {
                if(a[mid] > a[mid+1] && a[mid]>a[mid-1]) return mid;
                else if(a[mid]<a[mid-1]) return peak(a,l,mid-1);
                return peak(a,mid+1,h);
            }

        }
        return -1;
    }
    public static void main(String args[]) {
        int a[] = {2,1};
        System.out.println(peak(a, 0,a.length-1));
    }
}
