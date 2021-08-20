import java.util.Arrays;

public class RangeMinimumQuery {

    static int seg[];
    public static int createSegTree(int a[], int l, int r, int i) {
        if(l==r) {
            seg[i] = a[l];
            return seg[i];
        }
        int mid = l + (r-l)/2;
        seg[i] = Math.min(createSegTree(a,l,mid,2*i+1), createSegTree(a,mid+1,r,2*i+2));
        return seg[i];
    }

    public static int getMin(int ql, int qr, int l, int r, int i) {
        if(r<ql || l>qr) return Integer.MAX_VALUE;
        else if(l>=ql && r<=qr) return seg[i];
        else {
            int mid = l + (r-l)/2;
            return Math.min(getMin(ql,qr,l,mid,2*i+1), getMin(ql,qr,mid+1,r,2*i+2));
        }
    }
    public static void update(int l,int r, int i, int j, int val) {
        if(l==r && l==i) {
            seg[j] = val;
            return;
        }
        if(l<=i && r>=i) {
            if(seg[j]>val) seg[j]=val;
            int mid = l + (r-l)/2;
            update(l,mid,i,2*j+1,val);
            update(mid+1,r,i,2*j+2,val);
        }
    }
    public static void main(String args[]) {
        int a[] = {5,2,7,1,3};
        int n = a.length;
        seg = new int[2*n+2];
        createSegTree(a,0,n-1,0);
        System.out.println(Arrays.toString(seg));
        System.out.println(getMin(2,4,0,n-1,0));
        a[2] = -1;
        update(0,n-1,2,0,-1);
        System.out.println(Arrays.toString(seg));
    }
}
