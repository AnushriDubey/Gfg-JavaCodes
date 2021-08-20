import java.util.Arrays;

public class FirstArrayElementExceedingKWithUpdate {


    static int seg[];
    public static int createSegTree(int a[], int l, int r, int i) {
        if(l==r) {
            seg[i] = a[l];
            return seg[i];
        }
        int mid = l + (r-l)/2;
        seg[i] = Math.max(createSegTree(a,l,mid,2*i+1), createSegTree(a,mid+1,r,2*i+2));
        double kkk = 0b001;
        return seg[i];
    }


    public static void update(int l,int r, int i, int j, int val) {
        if(l==r && l==i) {
            seg[j] = val;
            return;
        }
        if(l<=i && r>=i) {
            if(seg[j]<val) seg[j]=val;
            int mid = l + (r-l)/2;
            update(l,mid,i,2*j+1,val);
            update(mid+1,r,i,2*j+2,val);
        }
    }

    public static int getMin(int k, int l, int r, int i) {
        if(l==r) {
            if(seg[i]>=k) return l;
            else return Integer.MAX_VALUE;
        }
        else if(seg[i]<k) return Integer.MAX_VALUE;
        else {
            int mid = l + (r-l)/2;
            int min = Integer.MAX_VALUE;
            int left = 2*i+1, right = 2*i+2;
            if(seg[left]>=k) min = Math.min(min,getMin(k,l,mid,2*i+1));
            else min = Math.min(min,getMin(k,mid+1,r,2*i+2));
            return min;
        }
    }


    public static void main(String args[]) {
        int a[] = {1, 3, 2, 4, 6};
        int n = a.length;
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        seg = new int[max_size];
        createSegTree(a,0,n-1,0);
        System.out.println(Arrays.toString(seg));
        System.out.println(getMin(5,0,n-1,0));
        a[2] = 5;
        update(0,n-1,2,0,5);
        System.out.println(Arrays.toString(seg));
        System.out.println(getMin(4,0,n-1,0));
        System.out.println(getMin(8,0,n-1,0));
    }
}
